package Lab5_Annotation_Validation.Validator;

import Lab5_Annotation_Validation.Annotation.ValidUniversityCapacity;
import Lab5_Annotation_Validation.Model.University;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniversityCapacityValidator implements ConstraintValidator<ValidUniversityCapacity, University> {

    @Override
    public boolean isValid(University university, ConstraintValidatorContext context) {
        if (university.getStudentCount() == null || university.getAuditoriumCapacity() == null) {
            return true; // Null-поля обрабатываются другими аннотациями
        }
        return university.getStudentCount() <= university.getAuditoriumCapacity() * 3;
    }
}
