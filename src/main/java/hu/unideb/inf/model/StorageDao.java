package hu.unideb.inf.model;


import java.util.List;

public interface StorageDao extends AutoCloseable{
    public void saveItems(Storage a);
    public List<Storage> getStorage();
    public void updateStorage(List<Storage> lista);
}
