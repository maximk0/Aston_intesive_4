package com.example.fragmentsapi.second_task

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.fragmentsapi.R
import com.example.fragmentsapi.databinding.FragmentUsersBinding
import com.example.fragmentsapi.second_task.EditFragment.Companion.ARG_SAVE_LAST_NAME
import com.example.fragmentsapi.second_task.EditFragment.Companion.ARG_SAVE_NAME
import com.example.fragmentsapi.second_task.EditFragment.Companion.ARG_SAVE_NUMBER
import com.example.fragmentsapi.second_task.data.UsersGenerator.editUserLastName
import com.example.fragmentsapi.second_task.data.UsersGenerator.editUserName
import com.example.fragmentsapi.second_task.data.UsersGenerator.editUserNumber
import com.example.fragmentsapi.second_task.data.UsersGenerator.users

class UsersFragment : Fragment(R.layout.fragment_users) {

    private lateinit var binding: FragmentUsersBinding

    private val adapter = UsersRecyclerViewAdapter { userId -> onClickUser(userId) }

    private var userId = 0

    override fun onResume() {
        super.onResume()
        getFragmentResult(EditFragment.KEY_SAVE_NAME, ARG_SAVE_NAME)
        getFragmentResult(EditFragment.KEY_SAVE_LAST_NAME, ARG_SAVE_LAST_NAME)
        getFragmentResult(EditFragment.KEY_SAVE_NUMBER, ARG_SAVE_NUMBER)
        adapter.setData(users)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUsersBinding.bind(view)

        binding.recyclerview.adapter = adapter
        adapter.setData(users)

    }

    private fun getFragmentResult(key: String, arg: String) {
        var result: String
        setFragmentResultListener(key) { _, bundle ->
            result = bundle.getString(arg).toString()
            if (userId != 0 && bundle.getString(arg) != null && bundle.getString(arg) != "") {
                when(arg) {
                    ARG_SAVE_NAME -> editUserName(userId, result)
                    ARG_SAVE_LAST_NAME -> editUserLastName(userId, result)
                    ARG_SAVE_NUMBER -> editUserNumber(userId, result)
                }
            }
        }
        userId = 0
    }

    private fun onClickUser(id: Int) {
        userId = id
        val user = users[id - 1]

        setFragmentResult(KEY_NAME, bundleOf(ARG_NAME to user.name))
        setFragmentResult(KEY_LAST_NAME, bundleOf(ARG_LAST_NAME to user.lastName))
        setFragmentResult(KEY_NUMBER, bundleOf(ARG_NUMBER to user.phoneNumber))

        parentFragmentManager.beginTransaction().run{
            val fragment = EditFragment.newInstance()
            setReorderingAllowed(true)
            replace(R.id.fragment_container_view, fragment, EditFragment.TAG)
            addToBackStack(EditFragment.TAG)
            commit()
        }
    }

    companion object {
        fun newInstance() = UsersFragment()
        const val TAG = "UsersFragment"

        const val KEY_NAME = "keyName"
        const val KEY_LAST_NAME = "keyLastName"
        const val KEY_NUMBER = "keyPhoneNumber"

        const val ARG_NAME = "argName"
        const val ARG_LAST_NAME = "argName"
        const val ARG_NUMBER = "argNumber"
    }
}
