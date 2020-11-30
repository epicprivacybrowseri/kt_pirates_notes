package ua.com.anyapps.kt_pirates_notes.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list_of_notes.*
import ua.com.anyapps.kt_pirates_notes.R
import ua.com.anyapps.kt_pirates_notes.adapter.ListOfNotesAdapter
import ua.com.anyapps.kt_pirates_notes.model.NoteModel
import ua.com.anyapps.kt_pirates_notes.utils.TAG
import ua.com.anyapps.kt_pirates_notes.viewmodel.ListOfNotesViewModel

class ListOfNotesFragment : Fragment(), CellClickListener {

    private lateinit var listOfNotesViewModel: ListOfNotesViewModel
    private lateinit var adapter: ListOfNotesAdapter

    private val noteListObserver = Observer<List<NoteModel>> {
        adapter.update(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_list_of_notes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        initObservers()
    }

    fun setupUI() {
        adapter = ListOfNotesAdapter(this)
        rvNotesList.layoutManager = LinearLayoutManager(requireContext())
        rvNotesList.adapter = adapter
    }

    private fun setupViewModel() {
        listOfNotesViewModel = ViewModelProviders.of(this).get(ListOfNotesViewModel::class.java)

    }

    private fun initObservers() {
        listOfNotesViewModel.getNoteListObservable().observe(this, noteListObserver)
    }

    override fun onCellClickListener(dbId: Int) {
        Log.d(TAG, "LIST CLICK: " + dbId)

        val bundle = Bundle()
        bundle.putInt("act", dbId)
        findNavController().navigate(R.id.addNoteFragment, bundle)
    }
}

interface CellClickListener {
    fun onCellClickListener(position: Int)
}