package Lab2_Decorator.Decorator;

import Lab2_Decorator.Abstraction.Pizza;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
@AllArgsConstructor
@NoArgsConstructor
public class PizzaWithPepper implements Pizza {

    private String additionalIngredient = " + Перец";

    @Delegate
    @Inject
    private Pizza pizza;

    @Override
    public String getDescription() {
        String baseDescription = pizza.getDescription();

        return baseDescription + additionalIngredient;
    }
}
