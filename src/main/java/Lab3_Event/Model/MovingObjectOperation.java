package Lab3_Event.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovingObjectOperation {
    private MovingObject movingObject; // Объект перемещения
    private Node from; // Начальный узел графа
    private Node to; // Конечный узел графа
    private Double delayInHours; // Время задержки в часах
    private Double distance; // Расстояние между узлами

    public MovingObjectOperation(MovingObject movingObject, Node from, Node to, Double delayInHours) {
        this.movingObject = movingObject;
        this.from = from;
        this.to = to;
        this.delayInHours = delayInHours;
    }
}
