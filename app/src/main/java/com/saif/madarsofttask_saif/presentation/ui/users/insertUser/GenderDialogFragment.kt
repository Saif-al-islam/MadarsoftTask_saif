package com.saif.madarsofttask_saif.presentation.ui.users.insertUser

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.saif.madarsofttask_saif.databinding.FragmentGenderDialogBinding
import com.saif.madarsofttask_saif.domain.core.enums.Gender
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenderDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentGenderDialogBinding


    var onItemSelected: (gender: Gender) -> Unit = {}

    companion object {
        fun newInstance() = GenderDialogFragment()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentGenderDialogBinding.inflate(inflater, container, false)

        onClicks()

        return binding.root
    }

    private fun onClicks() = with(binding) {
        tvMale.setOnClickListener {
            onItemClicked(Gender.Male)
        }

        tvFemale.setOnClickListener {
            onItemClicked(Gender.Female)
        }

        ivClose.setOnClickListener {
            dismiss()
        }
    }

    private fun onItemClicked(gender: Gender) {
        onItemSelected(gender)
        dismiss()
    }

}