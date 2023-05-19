package com.saif.madarsofttask_saif.domain.useCase.users

import android.util.Log
import com.saif.madarsofttask_saif.domain.core.enums.Gender
import com.saif.madarsofttask_saif.domain.models.User
import com.saif.madarsofttask_saif.domain.repository.users.UsersRepository
import javax.inject.Inject

class InsertUserUseCase @Inject constructor(
    private val repository: UsersRepository
) {

    @Throws(InsertUserException::class)
    suspend operator fun invoke(user: User) {
        Log.d("saif", "invoke: user= $user")

        if (user.username.isBlank() || user.username.length <= 2)
            throw InsertUserException.UserNameNotValid

        if (user.age <= 12)
            throw InsertUserException.AgeNotValid

        if (user.jobTitle.isBlank())
            throw InsertUserException.JobTitleEmpty

        if (user.gender == null)
            throw InsertUserException.GenderEmpty

        repository.insertUser(user)
    }

}

sealed class InsertUserException(msg: String) : Exception(msg) {
    object UserNameNotValid : InsertUserException("Username is not valid")
    object AgeNotValid : InsertUserException("Age is not valid")
    object JobTitleEmpty : InsertUserException("job Title is Empty")
    object GenderEmpty : InsertUserException("Gender is Empty")
}

var gender: Gender = Gender.Male