package com.saif.madarsofttask_saif.domain.models

import com.saif.madarsofttask_saif.domain.core.enums.Gender

data class User(
    var id: Long = 0,
    var username: String = "",
    var age: Int = 0,
    var jobTitle: String = "",
    var gender: Gender? = null
)

