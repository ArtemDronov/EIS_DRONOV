package Lab5_Annotation_Validation;

import Lab5_Annotation_Validation.Model.University;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

public class Laboratory5 {

    public static void main(String[] args) {
        // Создаем экземпляры университета
        University validUniversity = new University(300, 100); // Валидный
        University invalidUniversity = new University(400, 100); // Невалидный

        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        // Проверяем валидный университет
        System.out.println("Валидный университет:");
        validator.validate(validUniversity).forEach(violation -> System.out.println(violation.getMessage()));

        // Проверяем невалидный университет
        System.out.println("\nНевалидный университет:");
        validator.validate(invalidUniversity).forEach(violation -> System.out.println(violation.getMessage()));
    }
}
