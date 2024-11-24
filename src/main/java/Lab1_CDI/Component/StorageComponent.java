package Lab1_CDI.Component;

import Lab1_CDI.Annotation.ArrayStorage;
import Lab1_CDI.Annotation.LinkedListStorage;
import Lab1_CDI.Annotation.SetStorage;
import Lab1_CDI.Interceptor.StorageInterceptor;
import Lab1_CDI.Storage.StorageManager;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.Collection;

@Interceptors(StorageInterceptor.class) // Interceptor
@NoArgsConstructor
public class StorageComponent<T> {

    @Inject
//    @ArrayStorage
//    @LinkedListStorage
     @SetStorage
    private StorageManager<T> storageManager;

    public void addItem(T item) {
        storageManager.addItem(item);
    }

    public Collection<T> getItems() {
        return storageManager.getItems();
    }

    @Override
    public String toString() {
        String storageType;

        if (storageManager.getClass().isAnnotationPresent(ArrayStorage.class)) {
            storageType = "ArrayStorage";
        } else if (storageManager.getClass().isAnnotationPresent(LinkedListStorage.class)) {
            storageType = "LinkedListStorage";
        } else if (storageManager.getClass().isAnnotationPresent(SetStorage.class)) {
            storageType = "SetStorage";
        } else {
            storageType = "UnknownStorage";
        }

        return "StorageComponent{" +
                "type=" + storageType +
                ", items=" + getItems() +
                '}';
    }
}
