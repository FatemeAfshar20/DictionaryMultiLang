package com.example.dictionarymultilang.Database.Repository;

import android.content.Context;

import androidx.room.Room;

import com.example.dictionarymultilang.Database.DAO.PersianDAO;
import com.example.dictionarymultilang.Database.DictionaryDatabase;
import com.example.dictionarymultilang.Database.DictionarySchema;
import com.example.dictionarymultilang.Model.PersianWords;
import com.example.dictionarymultilang.Model.PersianWords;

import java.util.List;
import java.util.UUID;

public  class PersianDBRepository implements IRepository<PersianWords>{
    private static PersianDBRepository sInstance;
    private Context mContext;
    private PersianDAO mDAO;


    public static PersianDBRepository getInstance(Context context) {
        if(sInstance==null)
            sInstance=new PersianDBRepository(context);
        return sInstance;
    }

    private PersianDBRepository(Context context) {
        mContext=context.getApplicationContext();

        DictionaryDatabase dictionaryDatabase= Room.
                databaseBuilder(mContext,
                        DictionaryDatabase.class,
                        DictionarySchema.NAME).
                allowMainThreadQueries()
                .build();

        mDAO=dictionaryDatabase.getPersianDao();
    }


    @Override
    public void insert(PersianWords word) {
        mDAO.insert(word);
    }

    @Override
    public void update(PersianWords word) {
        mDAO.update(word);
    }

    @Override
    public void delete(PersianWords word) {
        mDAO.delete(word);
    }

    @Override
    public List<PersianWords> getLists() {
        return mDAO.getLists();
    }

    @Override
    public PersianWords get(UUID id) {
        return mDAO.get(id);
    }

}
