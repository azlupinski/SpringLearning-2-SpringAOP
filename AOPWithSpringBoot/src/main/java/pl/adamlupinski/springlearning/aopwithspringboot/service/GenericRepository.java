package pl.adamlupinski.springlearning.aopwithspringboot.service;

public interface GenericRepository<K,T> {
    T get(K id);
    void add(T obj);
}
