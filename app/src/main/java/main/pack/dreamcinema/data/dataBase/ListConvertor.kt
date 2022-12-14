package main.pack.dreamcinema.data.dataBase

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListConvertor {
    @TypeConverter
    fun fromList(value: List<Int>?): String? {
        val gson = Gson()
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toList(value: String?): List<Int>? {
        val gson = Gson()
        val type = object : TypeToken<List<Int>>() {}.type
        return gson.fromJson(value, type)
    }
}