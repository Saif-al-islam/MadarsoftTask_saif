package com.saif.madarsofttask_saif.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saif.madarsofttask_saif.data.local.users.UserDao
import com.saif.madarsofttask_saif.data.model.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}