package Lab3_Event.Model;

import Lab3_Event.Annotation.AddedOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Graph {
    // Список узлов графа
    private List<Node> nodes = new ArrayList<>();  // Инициализируем список узлов
    // Список рёбер графа
    private List<Edge> edges = new ArrayList<>();  // Инициализируем список рёбер
    // Местоположения объектов в графе
    private Map<MovingObject, Node> objectLocations = new HashMap<>();
    // Операции для каждого объекта
    private Map<MovingObject, List<MovingObjectOperation>> objectOperations = new HashMap<>();

    @Inject
    @AddedOperation
    private Event<List<MovingObjectOperation>> operationEvent;

    // Добавить узел в граф
    public void addNode(Node node) {
        if (!nodes.contains(node)) {
            nodes.add(node);
        }
    }

    // Добавить ребро в граф
    public void addEdge(Node from, Node to, double distance) {
        // Добавляем ребро от from к to
        Edge edge1 = new Edge(from, to, distance);
        edges.add(edge1);

        // Добавляем ребро от to к from (для неориентированного графа)
        Edge edge2 = new Edge(to, from, distance);
        edges.add(edge2);
    }

    // Найти ребро на основе узлов from и to
    public Edge findEdge(Node from, Node to) {
        // Ищем ребро в обеих направлениях
        return edges.stream()
                .filter(edge -> (edge.getFrom().equals(from) && edge.getTo().equals(to)) ||
                        (edge.getFrom().equals(to) && edge.getTo().equals(from)))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Ребро между узлами "
                        + from.getName() + " и "
                        + to.getName() + " не найдено."));
    }

    // Добавить операцию перемещения для объекта
    public void addOperation(MovingObjectOperation operation) {
        MovingObject object = operation.getMovingObject();
        Node from = operation.getFrom();
        Node to = operation.getTo();

        // Проверка существования ребра и получение расстояния
        Edge edge = findEdge(from, to);
        operation.setDistance(edge.getDistance());

        // Установить начальное местоположение объекта, если его нет в objectLocations
        if (!objectLocations.containsKey(object)) {
            objectLocations.put(object, from);
            System.out.println("Объект " + object.getName() + " добавлен в граф с местоположением: " + from.getName());
        }

        // Добавить операцию в objectOperations
        objectOperations.computeIfAbsent(object, k -> new ArrayList<>()).add(operation);

        // Выполнить операции для объекта
        executeLastOperation(object);

        // Отправить событие с обновлённым списком операций
        List<MovingObjectOperation> operations = objectOperations.get(object);
        operationEvent.fire(operations);  // Отправляем событие
    }

    // Переместить объект по операции
    private void moveObject(MovingObjectOperation operation) {
        MovingObject object = operation.getMovingObject();
        Node from = operation.getFrom();
        Node to = operation.getTo();

        // Проверка текущего местоположения объекта
        if (!objectLocations.get(object).equals(from)) {
            throw new IllegalStateException("Объект не находится в ожидаемом месте.");
        }

        // Проверка существования ребра
        Edge edge = findEdge(from, to);

        // Лог перемещения объекта
        System.out.println("Перемещаем объект " + object.getName() +
                " через ребро из " + edge.getFrom().getName() +
                " в " + edge.getTo().getName() + ", расстояние: " + edge.getDistance());

        // Переместить объект
        objectLocations.put(object, to);
    }

    // Выполнить только последнюю операцию для объекта
    public void executeLastOperation(MovingObject object) {
        if (!objectOperations.containsKey(object)) {
            System.out.println("Для объекта не найдено операций: " + object.getName());
            return;
        }

        List<MovingObjectOperation> operations = objectOperations.get(object);

        if (operations.isEmpty()) {
            System.out.println("Нет операций для объекта " + object.getName());
            return;
        }

        // Получаем последнюю операцию
        MovingObjectOperation lastOperation = operations.get(operations.size() - 1);
        moveObject(lastOperation);
        System.out.println("Объект " + object.getName() +
                " перемещен из " + lastOperation.getFrom().getName() +
                " в " + lastOperation.getTo().getName() +
                " с задержкой: " + lastOperation.getDelayInHours() + " часов.");
    }

    // Получить текущее местоположение объекта
    public Node getObjectLocation(MovingObject object) {
        return objectLocations.get(object);
    }

    // Вывести состояние графа
    public void printGraph() {
        System.out.println();
        System.out.println("ГРАФ");
        System.out.println("Узлы:");
        for (Node node : nodes) {
            System.out.println("- " + node);
        }
        System.out.println("\nРёбра:");
        for (Edge edge : edges) {
            System.out.println("- Из: " + edge.getFrom().getName() +
                    " В: " + edge.getTo().getName() +
                    " Расстояние: " + edge.getDistance());
        }
        System.out.println("\nМестоположения объектов:");
        for (Map.Entry<MovingObject, Node> entry : objectLocations.entrySet()) {
            System.out.println("- Объект: " + entry.getKey().getName() +
                    " Местоположение: " + entry.getValue().getName());
        }
        System.out.println("\nОперации объектов:");
        for (Map.Entry<MovingObject, List<MovingObjectOperation>> entry : objectOperations.entrySet()) {
            System.out.println("- Объект: " + entry.getKey().getName());
            for (MovingObjectOperation operation : entry.getValue()) {
                System.out.println("  - Из: " + operation.getFrom().getName() +
                        " В: " + operation.getTo().getName() +
                        " Задержка: " + operation.getDelayInHours() + " часов.");
            }
        }
    }
}
