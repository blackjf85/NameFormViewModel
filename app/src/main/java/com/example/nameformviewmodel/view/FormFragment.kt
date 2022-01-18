package com.example.nameformviewmodel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nameformviewmodel.R
import com.example.nameformviewmodel.databinding.FragmentFormBinding
import com.example.nameformviewmodel.viewmodel.FormViewModel

class FormFragment: Fragment() {

    private var _binding: FragmentFormBinding? = null
    private val binding: FragmentFormBinding get() = _binding!!

    private lateinit var viewModel: FormViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[FormViewModel::class.java]
        with(binding) {
            submitBtn.setOnClickListener {
                val firstNameStr = firstNameEt.text.toString()
                val lastNameStr = lastNameEt.text.toString()
                viewModel.addNameToList(NameData(firstNameStr, lastNameStr))

                val bundle = Bundle()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_view, DisplayFragment::class.java, bundle)
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