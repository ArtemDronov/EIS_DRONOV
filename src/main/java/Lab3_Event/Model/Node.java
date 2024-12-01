package Lab3_Event.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node {
    private Integer id; // Уникальный идентификатор узла
    private String name; // Название узла
}
