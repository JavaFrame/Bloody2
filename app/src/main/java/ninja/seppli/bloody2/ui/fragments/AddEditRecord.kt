package ninja.seppli.bloody2.ui.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import ninja.seppli.bloody2.R
import ninja.seppli.bloody2.databinding.AddEditRecordFragmentBinding
import ninja.seppli.bloody2.model.Record

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

        return inflater.inflate(R.layout.add_edit_record_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddEditRecordViewModel::class.java)
        binding.record = viewModel.record
        binding.controller = this
    }

    fun onSaveBtnClicked(view: View) {
        findNavController().navigate(AddEditRecordDirections.actionAddEditRecordToMain());
    }

    fun onCancelBtnClicked(view: View) {
        findNavController().navigate(AddEditRecordDirections.actionAddEditRecordToMain());
    }

}
