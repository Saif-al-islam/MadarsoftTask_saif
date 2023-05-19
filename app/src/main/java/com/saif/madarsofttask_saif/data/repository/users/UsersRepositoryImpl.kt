package com.saif.madarsofttask_saif.data.repository.users

import com.saif.madarsofttask_saif.data.local.users.UserDao
import com.saif.madarsofttask_saif.data.model.mapTo
import com.saif.madarsofttask_saif.domain.models.User
import com.saif.madarsofttask_saif.domain.repository.users.UsersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class UsersRepositoryImpl @Inject constructor(private val usersDao: UserDao) : UsersRepository {

    override suspend fun insertUser(user: User) {
        usersDao.insertUser(user.mapTo())
    }

    override fun getAllUser(): Flow<List<User>> {
        return usersDao.getAllUser().map { it.map { it.mapTo() } }
    }


}