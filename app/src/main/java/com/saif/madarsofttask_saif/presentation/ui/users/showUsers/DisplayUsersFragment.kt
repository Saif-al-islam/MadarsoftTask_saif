package com.saif.madarsofttask_saif.presentation.ui.users.showUsers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.saif.madarsofttask_saif.R
import com.saif.madarsofttask_saif.databinding.FragmentDisplayUsersBinding
import com.saif.madarsofttask_saif.presentation.core.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisplayUsersFragment : BaseFragment() {

    private lateinit var binding: FragmentDisplayUsersBinding
    private val viewModel: DisplayUsersViewModel by viewModels()
    private lateinit var adapter: UsersAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_display_users, container, false)

        setUp()

        return binding.root
    }

    private fun setUp() {
        binding.toolBar.toolBar.apply {
            title = getString(R.string.users_list)
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }

        adapter = UsersAdapter()
        binding.rvList.adapter = this@DisplayUsersFragment.adapter

        observeData()
    }

    private fun observeData() {
        observingData(
            rootView = binding.root,
            flow = viewModel.usersFlow,
            loadingView = binding.loadingLayout.loadingBar,
            loadingState = viewModel.loadingFlow,
        ) {
            when (it) {
                is SuccessGetUsersEvent ->
                    adapter.submitList(it.data)
            }
        }
    }

}