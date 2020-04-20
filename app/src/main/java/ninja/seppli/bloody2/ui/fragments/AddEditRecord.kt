package ninja.seppli.bloody2.ui.fragments

import android.app.DatePickerDialog
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import ninja.seppli.bloody2.R
import ninja.seppli.bloody2.databinding.AddEditRecordFragmentBinding
import ninja.seppli.bloody2.model.Record
import java.util.*

class AddEditRecord : Fragment() {

    companion object {
        fun newInstance() = AddEditRecord()
    }

    private lateinit var viewModel: AddEditRecordViewModel
    private lateinit var binding: AddEditRecordFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddEditRecordFragmentBinding.inflate(layoutInflater, container, false)

        binding.lifecycleOwner = activity
        binding.controller = this

        viewModel = ViewModelProviders.of(this).get(AddEditRecordViewModel::class.java)
        binding.record = viewModel.record

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun onDatePicker(view: View) {
        val cal = Calendar.getInstance()
        var date = DatePickerDialog.OnDateSetListener{
            view, year, month, dayOfMonth ->
            val cal = Calendar.getInstance()
            cal.set(year, month, dayOfMonth)
        }

        DatePickerDialog(context, date, cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH)).show()
    }

    fun onSaveBtnClicked(view: View) {
        findNavController().navigate(AddEditRecordDirections.actionAddEditRecordToMain());
    }

    fun onCancelBtnClicked(view: View) {
        findNavController().navigate(AddEditRecordDirections.actionAddEditRecordToMain());
    }

}
