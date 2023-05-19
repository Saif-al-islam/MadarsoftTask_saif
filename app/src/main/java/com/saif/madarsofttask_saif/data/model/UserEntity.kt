package com.saif.madarsofttask_saif.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.saif.madarsofttask_saif.domain.core.enums.Gender
import com.saif.madarsofttask_saif.domain.models.User

@Entity(tableName = "Users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val username: String,
    val age: Int,
    val jobTitle: String,
    val gender: String
)

fun UserEntity.mapTo() = User(
    id = id,
    username = username,
    age = age,
    jobTitle = jobTitle,
    gender = Gender.valueOf(gender)
)

fun User.mapTo() = UserEntity(
    username = username,
    age = age,
    jobTitle = jobTitle,
    gender = gender!!.name
)
