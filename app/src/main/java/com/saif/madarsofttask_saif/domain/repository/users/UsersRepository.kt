package com.saif.madarsofttask_saif.domain.repository.users

import com.saif.madarsofttask_saif.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun insertUser(user: User)

    fun getAllUser(): Flow<List<User>>

}