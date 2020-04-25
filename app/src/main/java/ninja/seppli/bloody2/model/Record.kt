package ninja.seppli.bloody2.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.databinding.ObservableFloat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * The record
 */
@Entity(tableName = "record")
data class Record (
    /**
     * the primary id
     */
    @PrimaryKey(autoGenerate = true)
    val id: Long = -1,
    /**
     * the actual blood sugar
     */
    var bloodSugar: Float = 0f,
    /**
     * when it was recored
     */
    var date:Date = Date(),
    /**
     * If an how much was eaten<br/>
     * zero = nothing eaten
     */
    var carbohydrates: Float = 0f,
    /**
     * How much insulin was injected for the food
     */
    var carbohydratesInsulin: Float = 0f,
    /**
     * how much insulin was injected because of high blood sugar
     */
    var correctionInsulin: Float = 0f,
    /**
     * a note
     */
    var note: String = ""
)
