package com.example.dictionarymultilang.Database.DAO;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.dictionarymultilang.Database.Repository.IRepository;
import com.example.dictionarymultilang.Model.EnglishWords;
import com.example.dictionarymultilang.Model.PersianWords;

import java.util.List;
import java.util.UUID;
@Dao
public interface PersianDAO extends IRepository<PersianWords> {
    @Query(value = "SELECT * FROM PersianWords")
    List<PersianWords> getLists();
    @Query(value = "SELECT * FROM PersianWords WHERE uuid=:id")
    PersianWords get(UUID id);
}
