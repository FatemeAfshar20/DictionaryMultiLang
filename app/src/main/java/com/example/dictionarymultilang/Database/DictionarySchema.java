package com.example.dictionarymultilang.Database;

public class DictionarySchema {
    public static final String NAME="dictionary.db";
    public static final int VERSION=1;

    public static final class PersianTable{
        public static final String NAME="PersianTable";
        public static final class PersianColumns{
            public static final String ID="";
            public static final String UUID="";
            public static final String WORD="";
            public static final String MEANING="";
            public static final String SYNONYM="";
        }
    }

    public static final class EnglishTable{
        public static final String NAME="EnglishTable";
        public static final class EnglishColumns{
            public static final String ID="";
            public static final String UUID="";
            public static final String WORD="";
            public static final String MEANING="";
            public static final String SYNONYM="";
        }
    }


}
