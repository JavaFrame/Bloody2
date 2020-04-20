package ninja.seppli.bloody2.ui.component.recordlist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ninja.seppli.bloody2.R
import ninja.seppli.bloody2.model.Record

class RecordListAdapter internal constructor(ctx: Context) :
    RecyclerView.Adapter<RecordListAdapter.RecordViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(ctx)
    private var records = emptyList<Record>()


    inner class RecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recordItemView: TextView = itemView.findViewById(R.id.records_recyclerview_item_textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecordViewHolder {
        val itemView = inflater.inflate(R.layout.records_recyclerview_item, parent, false)
        return RecordViewHolder(itemView)
    }

    override fun getItemCount(): Int = records.size

    override fun onBindViewHolder(holder: RecordViewHolder, position: Int) {
        val current = records[position]
        holder.recordItemView.text = current.bloodSugar.toString()
    }

    internal fun setRecords(records: List<Record>) {
        this.records = records
        notifyDataSetChanged()
    }
}