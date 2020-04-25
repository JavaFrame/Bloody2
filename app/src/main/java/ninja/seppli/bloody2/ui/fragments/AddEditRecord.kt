package ninja.seppli.bloody2.ui.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController

import ninja.seppli.bloody2.R
import java.util.*

class AddEditRecord : Fragment() {

    companion object {
        fun newInstance() = AddEditRecord()
    }

    private lateinit var viewModel: AddEditRecordViewModel
    private lateinit var date : EditText
    private lateinit var saveBtn: Button
    private lateinit var cancelBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.add_edit_record_fragment, container, false);
        date = view.findViewById(R.id.add_edit_record_date)
        saveBtn = view.findViewById(R.id.add_edit_record_save_btn)
        cancelBtn = view.findViewById(R.id.add_edit_record_cancel_btn)

        date.setOnFocusChangeListener { v, hasFocus ->  if(hasFocus) onDatePicker(v)}
        saveBtn.setOnClickListener(this::onSaveBtnClicked)
        cancelBtn.setOnClickListener(this::onCancelBtnClicked)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun onDatePicker(view: View) {
        val cal = Calendar.getInstance()
        var dateListener = DatePickerDialog.OnDateSetListener{
            view, year, month, dayOfMonth ->
            val cal = Calendar.getInstance()
            cal.set(year, month, dayOfMonth)
            viewModel.record.date = cal.time
        }

        val picker = DatePickerDialog(context, dateListener, cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH))
        picker.show()
    }

    fun onSaveBtnClicked(view: View) {
        findNavController().navigate(AddEditRecordDirections.actionAddEditRecordToMain());
    }

    fun onCancelBtnClicked(view: View) {
        findNavController().navigate(AddEditRecordDirections.actionAddEditRecordToMain());
    }

    private fun updateRecord() {
        val r = viewModel.record
    }
}
