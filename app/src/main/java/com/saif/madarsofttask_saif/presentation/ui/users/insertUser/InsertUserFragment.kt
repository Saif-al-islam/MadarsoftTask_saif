package com.saif.madarsofttask_saif.presentation.ui.users.insertUser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.saif.madarsofttask_saif.R
import com.saif.madarsofttask_saif.databinding.FragmentInsertUserBinding
import com.saif.madarsofttask_saif.presentation.core.BaseFragment
import com.saif.madarsofttask_saif.presentation.core.showSnackMsg
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InsertUserFragment : BaseFragment() {

    private lateinit var binding: FragmentInsertUserBinding
    private val viewModel: InsertUserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_insert_user, container, false)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@InsertUserFragment.viewModel
            clicker = InsertUserClicker()
        }
        observeData()

        return binding.root
    }

    private fun observeData() {
        observingData(
            rootView = binding.root,
            flow = viewModel.insertFlow,
            loadingView = binding.loadingLayout.loadingBar,
            loadingState = viewModel.loadingFlow,
            binding.btnDone, binding.btnShowUsers
        ) {
            when (it) {
                is SuccessInsertUserEvent -> {
                    binding.root.showSnackMsg(R.string.user_saved)
                    viewModel.clearRequest()
                    binding.invalidateAll()
                }
            }
        }
    }


    inner class InsertUserClicker {

        fun onInsertClick() {
            viewModel.insertUser()
        }

        fun onShowUsersClick() {
            findNavController().navigate(InsertUserFragmentDirections.actionInsertUserFragmentToDisplayUsersFragment())
        }

        fun onGenderClick() {
            GenderDialogFragment.newInstance().apply {
                onItemSelected = { gender ->
                    viewModel.userRequest.gender = gender
                    binding.invalidateAll()
                }
            }.show(childFragmentManager, null)
        }

    }
}


