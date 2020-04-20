package ninja.seppli.bloody2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ninja.seppli.bloody2.model.Record
import ninja.seppli.bloody2.model.RecordRepository
import ninja.seppli.bloody2.model.db.RecordRoomDatabase

class RecordViewModel(application: Application) : AndroidViewModel(application) {
    private val repo: RecordRepository
    val records: LiveData<List<Record>>

    init {
        val recordDao = RecordRoomDatabase.getDatabase(application).recordDao()
        repo = RecordRepository(recordDao)
        records  = repo.allRecords
    }

    fun insert(record: Record) = viewModelScope.launch { repo.insert(record) }
}