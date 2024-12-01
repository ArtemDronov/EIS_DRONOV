package Lab4_Validation.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeValidatedUniversity {

    @NotNull(message = "Название университета не должно быть пустым")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё\\s]+$", message = "Название университета должно содержать только буквы и пробелы")
    private String name;

    @NotNull(message = "Адрес университета не должен быть пустым")
    private String address;

    @Min(value = 1800, message = "Год основания не может быть раньше 1800")
    @Max(value = 2024, message = "Год основания не может быть позже текущего года")
    private int foundationYear;

    @NotNull(message = "Тип университета не должен быть пустым")
    @Pattern(regexp = "^(Государственный|Частный|Муниципальный)$", message = "Тип университета должен быть: Государственный, Частный или Муниципальный")
    private String universityType;
}
