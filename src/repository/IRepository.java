package repository;

public interface IRepository<T>{
    void create(T obj);
    void read(T obj);
    void update(T obj);
    void delete(T obj);
}
