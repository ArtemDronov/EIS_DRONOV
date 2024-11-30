package Lab3_Event.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
    private Node from; // Начальный узел
    private Node to; // Конечный узел
    private double distance; // Расстояние между узлами
}