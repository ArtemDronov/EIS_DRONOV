package Lab1_CDI.Storage;

import java.util.Collection;

public interface StorageManager<T> {
    void addItem(T item);
    Collection<T> getItems();
}
