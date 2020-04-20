package ninja.seppli.bloody2.model

import androidx.lifecycle.LiveData
import ninja.seppli.bloody2.model.Record
import ninja.seppli.bloody2.model.db.RecordDao

/**
 * The db repository
 */
class RecordRepository(private val recordDao: RecordDao) {
    /**
     * the live data
     */
    val allRecords: LiveData<List<Record>> = recordDao.getRecords()

    /**
     * inserts a new record
     */
    suspend fun insert(record: Record) : Long = recordDao.insert(record)
}