package Lab2_Decorator.Bean;

import Lab2_Decorator.Abstraction.Pizza;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Default;

@Default
@NoArgsConstructor
public class SimplePizza implements Pizza {

    @Override
    public String getDescription() {
        return "Простая пицца";
    }
}
