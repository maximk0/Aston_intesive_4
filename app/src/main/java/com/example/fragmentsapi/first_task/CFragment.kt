package com.example.fragmentsapi.first_task

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import com.example.fragmentsapi.R
import com.example.fragmentsapi.databinding.FragmentCBinding

class CFragment : Fragment(R.layout.fragment_c) {

    private lateinit var binding: FragmentCBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCBinding.bind(view)
        arguments?.getString(resources.getString(R.string.message))?.let { message ->
            binding.textView.text = message
        }

        binding.buttonGoA.setOnClickListener {
            parentFragmentManager.popBackStack(BFragment.TAG, POP_BACK_STACK_INCLUSIVE)
        }

        binding.buttonGoD.setOnClickListener {
            parentFragmentManager.beginTransaction().run{
                val fragment = DFragment.newInstance()
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, fragment, DFragment.TAG)
                addToBackStack(DFragment.TAG)
                commit()
            }
        }

    }

    companion object {
        fun newInstance(message: String) = CFragment().apply {
            arguments = Bundle().apply {
                putString(resources.getString(R.string.message), message)
            }
        }
        const val TAG = "CFragment"
    }

}
