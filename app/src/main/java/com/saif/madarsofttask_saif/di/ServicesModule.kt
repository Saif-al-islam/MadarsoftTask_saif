package com.saif.madarsofttask_saif.di

import com.saif.madarsofttask_saif.data.local.AppDatabase
import com.saif.madarsofttask_saif.data.local.users.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServicesModule {


    @Provides
    @Singleton
    fun providePostDBService(
        db: AppDatabase
    ): UserDao = db.userDao()


}