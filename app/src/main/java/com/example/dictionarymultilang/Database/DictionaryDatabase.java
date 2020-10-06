package com.example.dictionarymultilang.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.dictionarymultilang.Database.Converter.Converter;
import com.example.dictionarymultilang.Database.DAO.EnglishDAO;
import com.example.dictionarymultilang.Database.DAO.PersianDAO;
import com.example.dictionarymultilang.Model.EnglishWords;
import com.example.dictionarymultilang.Model.PersianWords;

@Database(entities = {PersianWords.class, EnglishWords.class}
,version = DictionarySchema.VERSION)
@TypeConverters({Converter.class})
public abstract class DictionaryDatabase extends RoomDatabase {
    public abstract PersianDAO getPersianDao();
    public abstract EnglishDAO getEnglishDao();
}
