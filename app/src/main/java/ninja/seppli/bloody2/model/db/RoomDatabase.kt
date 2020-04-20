package ninja.seppli.bloody2.model.db

import android.content.Context
import androidx.room.*
import ninja.seppli.bloody2.model.Converters
import ninja.seppli.bloody2.model.Record

@Database(entities = arrayOf(Record::class), version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RecordRoomDatabase : RoomDatabase() {
    abstract fun recordDao(): RecordDao

    companion object {
        @Volatile
        private var INSTANCE: RecordRoomDatabase? = null
        private val DB_NAME = "bloody_db"

        fun getDatabase(ctx: Context): RecordRoomDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        ctx.applicationContext,
                        RecordRoomDatabase::class.java,
                        DB_NAME
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}