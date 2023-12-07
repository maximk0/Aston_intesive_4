package com.example.fragmentsapi.first_task

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fragmentsapi.R
import com.example.fragmentsapi.databinding.FragmentDBinding

class DFragment : Fragment(R.layout.fragment_d) {

    private lateinit var binding: FragmentDBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDBinding.bind(view)

        binding.buttonGoB.setOnClickListener {
            parentFragmentManager.popBackStack(BFragment.TAG, 0)
        }

    }

    companion object {
        fun newInstance() = DFragment()
        const val TAG = "DFragment"
    }

}
