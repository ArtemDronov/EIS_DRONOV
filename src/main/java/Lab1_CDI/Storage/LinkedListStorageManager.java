package Lab1_CDI.Storage;


import Lab1_CDI.Annotation.LinkedListStorage;

import java.util.Collection;
import java.util.LinkedList;

@LinkedListStorage
public class LinkedListStorageManager<T> implements StorageManager<T> {
    private final LinkedList<T> storage = new LinkedList<>();

    @Override
    public void addItem(T item) {
        storage.add(item);
    }

    @Override
    public Collection<T> getItems() {
        return storage;
    }
}
