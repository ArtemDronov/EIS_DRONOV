package Lab2_Decorator;

import Lab2_Decorator.Bean.PizzaBean;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Laboratory2 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {

            PizzaBean pizzaBean = container.select(PizzaBean.class).get();

            System.out.println(pizzaBean.getDescription());

        } finally {
            weld.shutdown();
        }
    }
}
