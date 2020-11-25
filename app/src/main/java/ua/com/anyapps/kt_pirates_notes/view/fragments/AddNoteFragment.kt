package ua.com.anyapps.kt_pirates_notes.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_add_note.view.*
import ua.com.anyapps.kt_pirates_notes.R
import ua.com.anyapps.kt_pirates_notes.model.Note
import ua.com.anyapps.kt_pirates_notes.viewmodel.AddNoteViewModel


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddNoteFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddNoteFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    val TAG: String = "debapp"

    private lateinit var addNoteViewModel: AddNoteViewModel

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
        //addNoteViewModel.info.set("22222222222222")
        /*addNoteViewModel.noteTitle.observe(this, Observer{str: String?->
            Log.d(TAG, "Title2222: " + str)
        })*/
        val view: View = inflater.inflate(R.layout.fragment_add_note, container, false)
        addNoteViewModel.info2.observe(this, Observer{str: String?->
            Log.d(TAG, "From Model: " + str)
        })
        /*btnTestClick.setOnClickListener {
            Log.d(TAG, "ccccccccccccc")
        }*/




        /*
        //binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_note, container, false)
        val note: Note = Note("", "")
        addNoteViewModel = AddNoteViewModel(note)
        //binding?.lifecycleOwner = this
        binding?.viewModel = addNoteViewModel

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_add_note, container, false)
        return binding?.root*/
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.btnSave.setOnClickListener {
            val title: String = view.etTitle.text.toString()
            val text: String = view.etText.text.toString()

            addNoteViewModel.btnSaveNoteClicked(Note(title, text))
            findNavController().navigate(R.id.listOfNotesFragment)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddNoteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddNoteFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun setupModel() {
        addNoteViewModel = ViewModelProviders.of(this).get(AddNoteViewModel::class.java)
        addNoteViewModel.onMessageError.observe(this, onMessageErrorObserver)
    }

    private val onMessageErrorObserver = Observer<Any> {
        Toast.makeText(activity,"Error $it",Toast.LENGTH_SHORT).show()
    }
}