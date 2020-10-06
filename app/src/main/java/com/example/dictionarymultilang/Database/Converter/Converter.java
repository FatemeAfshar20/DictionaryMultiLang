package com.example.dictionarymultilang.Database.Converter;

import androidx.room.TypeConverter;

import java.util.UUID;

public class Converter {
    @TypeConverter
    public UUID conStrToUUID(String uuidStr){
        return UUID.fromString(uuidStr);
    }

    @TypeConverter
    public String conUUIDToStr(UUID uuid){
        return uuid.toString();
    }
}
