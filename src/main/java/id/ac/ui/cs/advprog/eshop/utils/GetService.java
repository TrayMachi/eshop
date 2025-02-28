package id.ac.ui.cs.advprog.eshop.utils;

import java.util.List;

public interface GetService<T> {
    List<T> findAll();
    T findById(String id);
}
