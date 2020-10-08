package com.example.dictionarymultilang.Model;

import android.app.SearchableInfo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.dictionarymultilang.Database.DictionarySchema.Columns;

import java.io.Serializable;
import java.util.UUID;

@Entity
public class EnglishWords implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private long mId;
    @ColumnInfo(name = Columns.UUID)
    private UUID mWordId;
    @ColumnInfo(name = Columns.WORD)
    private String mWord;
    @ColumnInfo(name = Columns.MEANING)
    private String mMeaning;
    @ColumnInfo(name = Columns.SYNONYM)
    private String mSynonym;


    public EnglishWords() {
        this(UUID.randomUUID());
    }

    public EnglishWords(UUID wordId) {
        mWordId = wordId;
    }
    @Ignore
    public EnglishWords(UUID wordId, String word, String meaning, String synonym) {
        mWordId = wordId;
        mWord = word;
        mMeaning = meaning;
        mSynonym = synonym;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public UUID getWordId() {
        return mWordId;
    }

    public void setWordId(UUID wordId) {
        mWordId = wordId;
    }

    public String getWord() {
        return mWord;
    }

    public void setWord(String word) {
        mWord = word;
    }

    public String getMeaning() {
        return mMeaning;
    }

    public void setMeaning(String meaning) {
        mMeaning = meaning;
    }

    public String getSynonym() {
        return mSynonym;
    }

    public void setSynonym(String synonym) {
        mSynonym = synonym;
    }
}
