package com.niallmurph.noteapp.util

import androidx.room.TypeConverter
import java.util.*

class DateConverter {
    @TypeConverter
    fun timeStampFromDate(date : Date) : Long {
        return date.time
    }

    @TypeConverter
    fun dateFromTimeStamp(timestamp : Long) : Date {
        return Date(timestamp)
    }
}