package com.saif.madarsofttask_saif.data.local.users

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.saif.madarsofttask_saif.data.model.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: UserEntity)

    @Query("SELECT * FROM Users")
    fun getAllUser(): Flow<List<UserEntity>>

}