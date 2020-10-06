package com.example.dictionarymultilang.Database.Repository;

import java.util.List;
import java.util.UUID;

public interface IRepository<E> {
    List<E> getLists();
    E get(UUID id);
    void insert(E e);
    void update(E e);
    void delete(E e);
    int getPosition(UUID crimeId);
}
