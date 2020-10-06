package com.example.dictionarymultilang.Database.Repository;

import android.content.Context;

import androidx.room.Room;

import com.example.dictionarymultilang.Database.DAO.EnglishDAO;
import com.example.dictionarymultilang.Database.DictionaryDatabase;
import com.example.dictionarymultilang.Database.DictionarySchema;
import com.example.dictionarymultilang.Model.EnglishWords;

import java.util.List;
import java.util.UUID;

public class EnglishDBRepository implements IRepository<EnglishWords> {
    private static EnglishDBRepository sInstance;
    private Context mContext;
    private EnglishDAO mDAO;


    public static EnglishDBRepository getInstance(Context context) {
        if(sInstance==null)
            sInstance=new EnglishDBRepository(context);
        return sInstance;
    }

    private EnglishDBRepository(Context context) {
        mContext=context.getApplicationContext();

        DictionaryDatabase dictionaryDatabase= Room.
                databaseBuilder(mContext,
                        DictionaryDatabase.class,
                        DictionarySchema.NAME).
                allowMainThreadQueries()
                .build();

        mDAO=dictionaryDatabase.getEnglishDao();
    }


    @Override
    public void insert(EnglishWords word) {
        mDAO.insert(word);
    }

    @Override
    public void update(EnglishWords word) {
        mDAO.update(word);
    }

    @Override
    public void delete(EnglishWords word) {
        mDAO.delete(word);
    }

    @Override
    public List<EnglishWords> getLists() {
        return mDAO.getLists();
    }

    @Override
    public EnglishWords get(UUID id) {
        return mDAO.get(id);
    }
}
