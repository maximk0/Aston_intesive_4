package com.example.fragmentsapi.second_task

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.fragmentsapi.R
import com.example.fragmentsapi.databinding.FragmentEditBinding
import com.example.fragmentsapi.second_task.UsersFragment.Companion.ARG_LAST_NAME
import com.example.fragmentsapi.second_task.UsersFragment.Companion.ARG_NAME
import com.example.fragmentsapi.second_task.UsersFragment.Companion.ARG_NUMBER
import com.example.fragmentsapi.second_task.UsersFragment.Companion.KEY_LAST_NAME
import com.example.fragmentsapi.second_task.UsersFragment.Companion.KEY_NAME
import com.example.fragmentsapi.second_task.UsersFragment.Companion.KEY_NUMBER

class EditFragment : Fragment(R.layout.fragment_edit) {

    private lateinit var binding: FragmentEditBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentEditBinding.bind(view)

        setFragmentResultListener(KEY_NAME) { _, bundle ->
            binding.name.text = bundle.getString(ARG_NAME)
        }
        setFragmentResultListener(KEY_LAST_NAME) { _, bundle ->
            binding.lastName.text = bundle.getString(ARG_LAST_NAME)
        }
        setFragmentResultListener(KEY_NUMBER) { _, bundle ->
            binding.phoneNumber.text = bundle.getString(ARG_NUMBER)
        }

        binding.saveBtn.setOnClickListener {
            val newName = binding.editName.text.toString()
            val newLastName = binding.editLastName.text.toString()
            val newPhone = binding.editPhone.text.toString()

            setFragmentResult(KEY_SAVE_NAME, bundleOf(ARG_SAVE_NAME to newName))
            setFragmentResult(KEY_SAVE_LAST_NAME, bundleOf(ARG_SAVE_LAST_NAME to newLastName))
            setFragmentResult(KEY_SAVE_NUMBER, bundleOf(ARG_SAVE_NUMBER to newPhone))

            parentFragmentManager.beginTransaction().run{
                parentFragmentManager.popBackStack()
                commit()
            }
        }

    }

    companion object {
        fun newInstance() = EditFragment()
        const val TAG = "EditFragment"

        const val KEY_SAVE_NAME = "keySaveName"
        const val KEY_SAVE_LAST_NAME = "keySaveLastName"
        const val KEY_SAVE_NUMBER = "keySaveNumber"

        const val ARG_SAVE_NAME = "saveName"
        const val ARG_SAVE_LAST_NAME = "saveLastName"
        const val ARG_SAVE_NUMBER = "saveNumber"
    }

}
