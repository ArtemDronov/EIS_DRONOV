package Lab3_Event.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Edge {
    private Node from; // Начальный узел
    private Node to; // Конечный узел
    private double distance; // Расстояние между узлами
}