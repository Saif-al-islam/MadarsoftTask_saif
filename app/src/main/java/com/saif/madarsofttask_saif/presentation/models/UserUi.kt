package com.saif.madarsofttask_saif.presentation.models

import com.saif.madarsofttask_saif.domain.core.enums.Gender

data class UserUi(
    var username: String = "",
    var age: String = "",
    var jobTitle: String = "",
    var gender: Gender? = null
)

