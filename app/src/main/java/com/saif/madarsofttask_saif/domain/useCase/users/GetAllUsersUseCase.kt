package com.saif.madarsofttask_saif.domain.useCase.users

import com.saif.madarsofttask_saif.domain.repository.users.UsersRepository
import javax.inject.Inject

class GetAllUsersUseCase @Inject constructor(
    private val repository: UsersRepository
) {

    operator fun invoke() = repository.getAllUser()

}