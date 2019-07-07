package dao;

public interface Dao<T> {
    T findById(long id);
    void save(T obj);
    void update(T obj);
    void delete(T obj);
    void delete(long id);
}
