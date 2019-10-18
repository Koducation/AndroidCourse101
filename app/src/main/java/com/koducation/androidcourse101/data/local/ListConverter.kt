package com.koducation.androidcourse101.data.local

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import com.koducation.androidcourse101.data.remote.model.Stream

class ListConverter {

    @TypeConverter
    fun stringListToJson(stringList: List<String>?): String {
        if (stringList.isNullOrEmpty()) {
            return ""
        }

        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.toJson(stringList, type)
    }

    @TypeConverter
    fun jsonToStringList(stringListJson: String): List<String> {
        val gson = Gson()
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(stringListJson, type)
    }

    @TypeConverter
    fun streamsToJson(streams: List<Stream>?): String {
        if (streams == null) {
            return ""
        }
        val gson = Gson()
        val type = object : TypeToken<List<Stream>>() {}.type
        return gson.toJson(streams, type)
    }

    @TypeConverter
    fun jsonToStreams(streamsJson: String): List<Stream> {
        val gson = Gson()
        val type = object : TypeToken<List<Stream>>() {}.type
        return gson.fromJson(streamsJson, type)
    }
}