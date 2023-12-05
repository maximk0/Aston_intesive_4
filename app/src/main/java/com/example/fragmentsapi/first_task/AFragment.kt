package com.example.fragmentsapi.first_task

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fragmentsapi.R
import com.example.fragmentsapi.databinding.FragmentABinding

class AFragment : Fragment(R.layout.fragment_a) {

    private lateinit var binding: FragmentABinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentABinding.bind(view)

        binding.buttonGoB.setOnClickListener {
            Log.d("TRANS", "first task fragment a")
            parentFragmentManager.beginTransaction().run{
                val fragment = BFragment.newInstance()
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, fragment, BFragment.TAG)
                addToBackStack(BFragment.TAG)
                commit()
            }
        }
    }

    companion object {
        fun newInstance() = AFragment()
        const val TAG = "AFragment"
    }

}
