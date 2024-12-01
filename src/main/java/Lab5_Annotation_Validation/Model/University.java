package Lab5_Annotation_Validation.Model;

import Lab5_Annotation_Validation.Annotation.ValidUniversityCapacity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ValidUniversityCapacity
public class University {

    @NotNull(message = "Количество обучающихся студентов не должно быть null")
    @Min(value = 0, message = "Количество обучающихся студентов должно быть больше или равно 0")
    private Integer studentCount;

    @NotNull(message = "Вместимость аудиторий не должна быть null")
    @Min(value = 1, message = "Вместимость аудиторий должна быть больше 0")
    private Integer auditoriumCapacity;
}
