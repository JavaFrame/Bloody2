package ninja.seppli.bloody2.model.db

import androidx.lifecycle.LiveData
import androidx.room.*
import ninja.seppli.bloody2.model.Record

/**
 * The dao for the records db
 */
@Dao
interface RecordDao {
    /**
     * @return returns all data
     */
    @Query("select * from record order by date ASC")
    fun getRecords() : LiveData<List<Record>>

    /**
     * Returns the record or null
     */
    @Query("select * from record where id = :id")
    fun getRecord(id: Long) : LiveData<Record?>

    /**
     * inserts the given record and returns its new id
     * @param record the record to add
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(record: Record): Long

    /**
     * Deletes the given record
     * @param record the record
     */
    @Delete
    suspend fun delete(record: Record)


    /**
     * deletes all values
     */
    @Query("delete from record")
    suspend fun deleteAll()
}