package id.ac.ui.cs.advprog.eshop.utils.RepositoryInterface;

import java.util.Iterator;

public interface BaseRepository<T> {
    T create(T car);
    Iterator<T> findAll();
    T findById(String id);
    T update(T updatedItem);
    boolean delete(T item);
}