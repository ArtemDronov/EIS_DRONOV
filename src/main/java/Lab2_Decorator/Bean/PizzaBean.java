package Lab2_Decorator.Bean;

import Lab2_Decorator.Abstraction.Pizza;

import javax.inject.Inject;

public class PizzaBean {

    @Inject
    private Pizza pizza;

    public String getDescription() {
        return pizza.getDescription();
    }
}
