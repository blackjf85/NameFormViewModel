package com.example.nameformviewmodel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nameformviewmodel.R
import com.example.nameformviewmodel.databinding.FragmentDisplayBinding
import com.example.nameformviewmodel.viewmodel.FormViewModel
import com.example.nameformviewmodel.viewmodel.User

class DisplayFragment: Fragment() {
    private var _binding: FragmentDisplayBinding? = null
    private val binding: FragmentDisplayBinding get() = _binding!!

    private lateinit var viewModel: FormViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDisplayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity()).get(FormViewModel::class.java)

        with(binding) {
            viewModel.users.observe(viewLifecycleOwner) { userName ->
                userNameTv.text = userName.get(0).firstName.toString()
            }

            backBtn.setOnClickListener {
                val bundle = Bundle()

                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, FormFragment::class.java, bundle)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


