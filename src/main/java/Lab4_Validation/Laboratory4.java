package Lab4_Validation;

import Lab4_Validation.Model.XmlValidatedUniversity;
import Lab4_Validation.Model.CodeValidatedUniversity;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Set;

public class Laboratory4 {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        XmlValidatedUniversity xmlUniversity = new XmlValidatedUniversity();
        xmlUniversity.setName("МГУ имени Ломоносова");
        xmlUniversity.setAddress("г. Москва, Ленинские Горы, 1");
        xmlUniversity.setFoundationYear(1800); // Ошибка: меньше 1800
        xmlUniversity.setUniversityType("Государственный");

        System.out.println("Валидация XmlValidatedUniversity:");
        validateAndPrint(validator, xmlUniversity);

        CodeValidatedUniversity codeUniversity = new CodeValidatedUniversity();
        codeUniversity.setName("123"); // Некорректное имя
        codeUniversity.setAddress(null); // Поле не должно быть пустым
        codeUniversity.setFoundationYear(2100); // Некорректное значение
        codeUniversity.setUniversityType("Некоммерческий"); // Некорректный тип

        System.out.println("\nВалидация CodeValidatedUniversity:");
        validateAndPrint(validator, codeUniversity);
    }

    private static <T> void validateAndPrint(Validator validator, T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (violations.isEmpty()) {
            System.out.println("Валидация прошла успешно!");
        } else {
            for (ConstraintViolation<T> violation : violations) {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
        }
    }
}
