package repository;

import model.HasID;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InMemoryRepo<T extends HasID> implements IRepository<T> {
    private final Map<Integer,T> data = new HashMap<>();
    private List<T> entities;

    @Override
    public void create(T obj) {
        data.putIfAbsent(obj.getId(), obj);
    }

    @Override
    public List<T> readAll() {
        return data.values().stream().toList();
    }

    @Override
    public void update(T obj) {
        data.replace(obj.getId(), obj);
    }

    @Override
    public void delete(Integer id) {
        data.remove(id);
    }

    @Override
    public T get(Integer id) {
        return data.get(id);
    }

    @Override
    public Set<Integer> getKeys() {
        return data.keySet();
    }


}
