package Lab1_CDI;

import Lab1_CDI.Component.StorageComponent;
import lombok.NoArgsConstructor;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

@NoArgsConstructor
public class Laboratory1 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {

        try {
            weld = new Weld();
            container = weld.initialize();

            StorageComponent<String> storage = container.select(StorageComponent.class).get();

            storage.addItem("Item 1");
            storage.addItem("Item 2");

            System.out.println(storage);

        } finally {
            weld.shutdown();
        }
    }
}
