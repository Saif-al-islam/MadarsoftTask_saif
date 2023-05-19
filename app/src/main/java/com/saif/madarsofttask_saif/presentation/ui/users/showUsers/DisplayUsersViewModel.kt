package com.saif.madarsofttask_saif.presentation.ui.users.showUsers

import androidx.lifecycle.viewModelScope
import com.saif.madarsofttask_saif.domain.models.User
import com.saif.madarsofttask_saif.domain.useCase.users.GetAllUsersUseCase
import com.saif.madarsofttask_saif.domain.useCase.users.InsertUserUseCase
import com.saif.madarsofttask_saif.presentation.core.BaseViewModel
import com.saif.madarsofttask_saif.presentation.core.UiEvent
import com.saif.madarsofttask_saif.presentation.models.UserUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisplayUsersViewModel @Inject constructor(
    private val GetAllUsersUseCase: GetAllUsersUseCase
) : BaseViewModel() {


    private val _usersFlow = MutableStateFlow(UiEvent())
    val usersFlow = _usersFlow.asStateFlow()

    init {
        getAllUsers()
    }


    private fun getAllUsers() {
        GetAllUsersUseCase()
            .onStart {
                _loadingFlow.emit(true)
            }
            .onEach {
                _loadingFlow.emit(false)
                _usersFlow.emit(SuccessGetUsersEvent(it))
            }
            .launchIn(viewModelScope)
    }


}


data class SuccessGetUsersEvent(
    val data: List<User>
) : UiEvent()
