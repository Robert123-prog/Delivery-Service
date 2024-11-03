package repository;

public interface IRepository<T>{
    void create();
    void read(T obj);
    void update(T obj);
    void delete(T obj);
}
