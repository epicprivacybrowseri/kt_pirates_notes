package ua.com.anyapps.kt_pirates_notes.view.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_of_notes.*
import ua.com.anyapps.kt_pirates_notes.R
import ua.com.anyapps.kt_pirates_notes.adapter.ListOfNotesAdapter
import ua.com.anyapps.kt_pirates_notes.model.Note
import ua.com.anyapps.kt_pirates_notes.viewmodel.ListOfNotesViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListOfNotesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListOfNotesFragment : Fragment(), CellClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val TAG: String = "debapp"
    private lateinit var listOfNotesViewModel: ListOfNotesViewModel
    private lateinit var adapter: ListOfNotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        setupModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_of_notes, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListOfNotesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListOfNotesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupList()
    }

    private fun setupModel() {
        listOfNotesViewModel = ViewModelProviders.of(this).get(ListOfNotesViewModel::class.java)
        listOfNotesViewModel.onMessageError.observe(this, onMessageErrorObserver)
    }

    private val onMessageErrorObserver = Observer<Any> {
        Toast.makeText(activity,"Error $it", Toast.LENGTH_SHORT).show()
    }

    private fun setupList(){
        listOfNotesViewModel.notesList.observe(this, onFillList)
    }

    private val onFillList = Observer<List<Note>> {
        adapter = ListOfNotesAdapter(it, this)
        rvNotesList.layoutManager = LinearLayoutManager(requireContext())
        rvNotesList.adapter = adapter
    }

    override fun onCellClickListener(position: Int) {
        Log.d(TAG, "LIST CLICK: " + position)
    }
}

interface CellClickListener {
    fun onCellClickListener(position: Int)
}