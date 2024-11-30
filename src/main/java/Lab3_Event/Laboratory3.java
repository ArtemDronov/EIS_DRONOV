package Lab3_Event;

import Lab3_Event.Model.*;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Laboratory3 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) throws Exception {
        weld = new Weld();
        container = weld.initialize();

        try {
            Graph graph = container.select(Graph.class).get();

            Node nodeA = new Node(1, "A");
            Node nodeB = new Node(2, "B");
            Node nodeC = new Node(3, "C");
            Node nodeD = new Node(4, "D");
            Node nodeE = new Node(5, "E");
            Node nodeF = new Node(6, "F");
            Node nodeG = new Node(7, "G");


            // Добавление узлов в граф
            graph.addNode(nodeA);
            graph.addNode(nodeB);
            graph.addNode(nodeC);
            graph.addNode(nodeD);
            graph.addNode(nodeE);
            graph.addNode(nodeF);
            graph.addNode(nodeG);

            // Инициализация рёбер
            graph.addEdge(nodeA, nodeB, 3.0);
            graph.addEdge(nodeA, nodeC, 6.0);
            graph.addEdge(nodeA, nodeD, 5.0);
            graph.addEdge(nodeB, nodeC, 21.0);
            graph.addEdge(nodeD, nodeC, 15.0);
            graph.addEdge(nodeC, nodeE, 13.0);
            graph.addEdge(nodeC, nodeF, 1.0);
            graph.addEdge(nodeC, nodeG, 34.0);
            graph.addEdge(nodeE, nodeF, 23.0);

            // Инициализация объектов
            MovingObject drone = new MovingObject(1, "Дрон");
            MovingObject truck = new MovingObject(2, "Грузовик");


            MovingObjectOperation operation1 = new MovingObjectOperation(drone, nodeA, nodeD, 2.0);
            MovingObjectOperation operation2 = new MovingObjectOperation(drone, nodeD, nodeC, 4.0);
            MovingObjectOperation operation3 = new MovingObjectOperation(drone, nodeC, nodeE, 12.0);
            MovingObjectOperation operation4 = new MovingObjectOperation(drone, nodeE, nodeF, 22.0);

            MovingObjectOperation operation5 = new MovingObjectOperation(truck, nodeA, nodeB, 13.0);
            MovingObjectOperation operation6 = new MovingObjectOperation(truck, nodeB, nodeC, 11.0);
            MovingObjectOperation operation7 = new MovingObjectOperation(truck, nodeC, nodeG, 9.0);

            // Добавление операций в граф
            graph.addOperation(operation1);
            graph.addOperation(operation2);
            graph.addOperation(operation3);
            graph.addOperation(operation4);
            graph.addOperation(operation5);
            graph.addOperation(operation6);
            graph.addOperation(operation7);

            graph.printGraph();

        } finally {
            weld.shutdown();
        }
    }

}
