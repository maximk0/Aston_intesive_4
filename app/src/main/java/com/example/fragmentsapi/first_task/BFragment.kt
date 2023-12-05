package com.example.fragmentsapi.first_task

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fragmentsapi.R
import com.example.fragmentsapi.databinding.FragmentBBinding

class BFragment : Fragment(R.layout.fragment_b) {

    private lateinit var binding: FragmentBBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBBinding.bind(view)

        binding.buttonGoC.setOnClickListener {
            parentFragmentManager.beginTransaction().run{
                val fragment = CFragment.newInstance(resources.getString(R.string.message))
                setReorderingAllowed(true)
                replace(R.id.fragment_container_view, fragment, CFragment.TAG)
                addToBackStack(CFragment.TAG)
                commit()
            }

        }

        binding.buttonBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

    }
    companion object {
        fun newInstance() = BFragment()
        const val TAG = "BFragment"
    }
}
