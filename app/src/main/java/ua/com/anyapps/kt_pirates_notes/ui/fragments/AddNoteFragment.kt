package ua.com.anyapps.kt_pirates_notes.ui.fragments

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_note.*
import ua.com.anyapps.kt_pirates_notes.R
import ua.com.anyapps.kt_pirates_notes.room.model.NoteEntity
import ua.com.anyapps.kt_pirates_notes.utils.TAG
import ua.com.anyapps.kt_pirates_notes.viewmodel.AddNoteViewModel

class AddNoteFragment : Fragment() {

    private lateinit var addNoteViewModel: AddNoteViewModel

    val btnSaveClickListener = View.OnClickListener { view: View? ->
        val title: String = etTitle.text.toString()
        val text: String = etText.text.toString()

        hideKeyboard()

        addNoteViewModel.btnSaveClick(NoteEntity(title, text))

        findNavController().navigate(R.id.listOfNotesFragment)

        /*var action: HomeFragmentDirections.ActionGoto1 =
                HomeFragmentDirections.actionGoto1()
        action.setAct(1)
        findNavController().navigate(action);*/
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_add_note, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListeners()

        if (arguments != null) {
            val safeArgs = ListOfNotesFragmentArgs.fromBundle(arguments!!)
            val flowStepNumber = safeArgs.act
            Log.d(TAG, "Arg: $flowStepNumber")
        }
    }

    private fun setupViewModel() {
        addNoteViewModel = ViewModelProviders.of(this).get(AddNoteViewModel::class.java)
    }

    fun initListeners() {
        btnSave.setOnClickListener(btnSaveClickListener)
    }

    fun hideKeyboard() {
        val inputMethodManager: InputMethodManager = activity!!.getSystemService(
            Activity.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(
            activity!!.currentFocus!!.windowToken, 0
        )
    }
}