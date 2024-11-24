package Lab1_CDI.Storage;

import Lab1_CDI.Annotation.ArrayStorage;

import java.util.ArrayList;
import java.util.Collection;

@ArrayStorage
public class ArrayStorageManager<T> implements StorageManager<T> {
    private final ArrayList<T> storage = new ArrayList<>();

    @Override
    public void addItem(T item) {
        storage.add(item);
    }

    @Override
    public Collection<T> getItems() {
        return storage;
    }
}
