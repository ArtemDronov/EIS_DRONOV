package Lab1_CDI.Storage;


import Lab1_CDI.Annotation.SetStorage;

import java.util.Collection;
import java.util.HashSet;

@SetStorage
public class SetStorageManager<T> implements StorageManager<T> {
    private final HashSet<T> storage = new HashSet<>();

    @Override
    public void addItem(T item) {
        storage.add(item);
    }

    @Override
    public Collection<T> getItems() {
        return storage;
    }
}
