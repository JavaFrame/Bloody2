package ninja.seppli.bloody2.model

import androidx.room.TypeConverter
import java.util.*

/**
 * Defines converters for the room db
 */
class Converters {
    companion object {
        /**
         * Converts from date to the time in ms
         */
        @TypeConverter
        @JvmStatic
        fun fromDate(date: Date) : Long = date.time

        /**
         * Converts the time in ms to a date
         */
        @TypeConverter
        @JvmStatic
        fun toDate(dateInMs : Long) : Date = Date(dateInMs)
    }
}