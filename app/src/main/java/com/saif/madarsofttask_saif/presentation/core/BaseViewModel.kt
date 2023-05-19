package com.saif.madarsofttask_saif.presentation.core

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


open class BaseViewModel : ViewModel() {


    protected val _loadingFlow by lazy { MutableStateFlow<Boolean>(false) }
    val loadingFlow by lazy { _loadingFlow.asStateFlow() }


}

