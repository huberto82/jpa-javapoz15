package dao;

import java.util.List;

public interface Dao<T> {
    List<T> findAll();
    T findById(long id);
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    void delete(long id);
}
