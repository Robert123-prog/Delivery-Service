package repository;

import model.HasID;

import java.util.List;

public interface IRepository<T extends HasID> {
    void create(T obj);
    List<T> read();
    void update(T obj);
    void delete(Integer id);
    T get(Integer id);
}
