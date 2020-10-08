package com.example.dictionarymultilang.Database.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.dictionarymultilang.Database.Repository.IRepository;
import com.example.dictionarymultilang.Model.EnglishWords;

import java.util.List;
import java.util.UUID;
@Dao
public interface EnglishDAO extends IRepository<EnglishWords> {
    @Query(value = "SELECT * FROM englishwords")
    List<EnglishWords> getLists();
    @Query(value = "SELECT * FROM englishwords WHERE uuid=:id")
    EnglishWords get(UUID id);
}
