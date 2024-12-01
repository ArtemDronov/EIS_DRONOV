package Lab5_Annotation_Validation.Annotation;

import Lab5_Annotation_Validation.Validator.UniversityCapacityValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniversityCapacityValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidUniversityCapacity {
    String message() default "Количество обучающихся студентов превышает вместимость аудиторий в 3 раза";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
