package ninja.seppli.bloody2.ui.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import ninja.seppli.bloody2.R
import ninja.seppli.bloody2.ui.component.recordlist.RecordListAdapter

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    /**
     * Init view elements
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // recycler view for records
        val recyclerView = view.findViewById<RecyclerView>(R.id.main_records_list)
        val adapter =
            RecordListAdapter(this.requireContext())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this.requireContext())

        val navCtrl = findNavController()


        // floating button
        val floatingBtn = view.findViewById<FloatingActionButton>(R.id.floatingBtn)
        floatingBtn.setOnClickListener { view ->
            Snackbar.make(view, "Here is a snackbar", Snackbar.LENGTH_LONG).setAction("Action", null).show()
                findNavController().navigate(MainFragmentDirections.actionMainToAddEditRecord())
        }
    }
}
