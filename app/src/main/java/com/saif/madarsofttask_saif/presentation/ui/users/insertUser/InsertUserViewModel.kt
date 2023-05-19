package com.saif.madarsofttask_saif.presentation.ui.users.insertUser

import androidx.lifecycle.viewModelScope
import com.saif.madarsofttask_saif.R
import com.saif.madarsofttask_saif.domain.models.User
import com.saif.madarsofttask_saif.domain.useCase.users.InsertUserException
import com.saif.madarsofttask_saif.domain.useCase.users.InsertUserUseCase
import com.saif.madarsofttask_saif.presentation.core.BaseViewModel
import com.saif.madarsofttask_saif.presentation.core.Error
import com.saif.madarsofttask_saif.presentation.core.UiEvent
import com.saif.madarsofttask_saif.presentation.models.UserUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsertUserViewModel @Inject constructor(
    private val InsertUserUseCase: InsertUserUseCase
) : BaseViewModel() {


    private val _insertFlow = MutableSharedFlow<UiEvent>()
    val insertFlow = _insertFlow.asSharedFlow()

    val userRequest = UserUi()


    fun clearRequest() {
        userRequest.apply {
            username = ""
            age = ""
            jobTitle = ""
            gender = null
        }
    }

    fun insertUser() {
        viewModelScope.launch(Dispatchers.IO) {
            _loadingFlow.emit(true)
            try {
                InsertUserUseCase(
                    User(
                        username = userRequest.username,
                        age = userRequest.age.toIntOrNull() ?: 0,
                        jobTitle = userRequest.jobTitle,
                        gender = userRequest.gender
                    )
                )
                _insertFlow.emit(SuccessInsertUserEvent)
            } catch (e: InsertUserException) {
                val msgInt = when (e) {
                    InsertUserException.AgeNotValid -> R.string.age_not_valid
                    InsertUserException.GenderEmpty -> R.string.gender_not_valid
                    InsertUserException.JobTitleEmpty -> R.string.job_title_not_valid
                    InsertUserException.UserNameNotValid -> R.string.username_not_valid
                }

                _insertFlow.emit(UiEvent.ShowMessage(Error.ErrorInt(msgInt)))
            }
            _loadingFlow.emit(false)
        }
    }


}


object SuccessInsertUserEvent : UiEvent()
