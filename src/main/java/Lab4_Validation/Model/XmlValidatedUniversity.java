package Lab4_Validation.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class XmlValidatedUniversity {

    private String name;
    private String address;
    private int foundationYear;
    private String universityType;
}
