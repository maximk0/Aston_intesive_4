package com.example.fragmentsapi

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fragmentsapi.databinding.FragmentMainBinding
import com.example.fragmentsapi.first_task.AFragment
import com.example.fragmentsapi.second_task.UsersFragment

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        binding.firstTaskBtn.setOnClickListener {
            Log.d("TRANS", "first task fragment main")
            parentFragmentManager.beginTransaction().run{
                val fragment = AFragment.newInstance()
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, fragment, AFragment.TAG)
                addToBackStack(AFragment.TAG)
                commit()
            }
        }

        binding.secondTaskBtn.setOnClickListener {
            Log.d("TRANS", "second task fragment main")
            parentFragmentManager.beginTransaction().run{
                val fragment = UsersFragment.newInstance()
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, fragment, UsersFragment.TAG)
                addToBackStack(UsersFragment.TAG)
                commit()
            }
        }
    }

    companion object {
        fun newInstance() = MainFragment()
        const val TAG = "MainFragment"
    }
}
