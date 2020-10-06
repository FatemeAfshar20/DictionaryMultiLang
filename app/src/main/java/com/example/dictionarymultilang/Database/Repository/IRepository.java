package com.example.dictionarymultilang.Database.Repository;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.dictionarymultilang.Model.EnglishWords;

import java.util.List;
import java.util.UUID;

public interface IRepository<E> {
    @Insert
    void insert(E word);

    @Update
    void update(E word);

    @Delete
    void delete(E word);

    List<E> getLists();

    E get(UUID id);
}
