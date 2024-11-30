package Lab3_Event.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovingObject {
    private Integer id; // Идентификатор объекта
    private String name; // Наименование объекта
}
