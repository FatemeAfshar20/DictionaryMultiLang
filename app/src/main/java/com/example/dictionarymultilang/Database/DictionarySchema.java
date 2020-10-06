package com.example.dictionarymultilang.Database;

public class DictionarySchema {
    public static final String NAME = "dictionary.db";
    public static final int VERSION = 1;

    public static final class PersianTable {
        public static final String NAME = "PersianTable";
        //TableColumns=Common Columns
    }

    public static final class EnglishTable {
        public static final String NAME = "EnglishTable";
        //TableColumns=Common Columns
    }

    //Common Columns
    public static final class Columns {
        public static final String ID = "id";
        public static final String UUID = "uuid";
        public static final String WORD = "word";
        public static final String MEANING = "meaning";
        public static final String SYNONYM = "synonym";
    }

}
