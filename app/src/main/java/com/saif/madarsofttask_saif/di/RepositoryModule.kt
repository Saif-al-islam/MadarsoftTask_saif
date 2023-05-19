package com.saif.madarsofttask_saif.di

import com.saif.madarsofttask_saif.data.local.users.UserDao
import com.saif.madarsofttask_saif.data.repository.users.UsersRepositoryImpl
import com.saif.madarsofttask_saif.domain.repository.users.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {


    @Provides
    @Singleton
    fun provideUsersRepository(
        dao: UserDao
    ): UsersRepository = UsersRepositoryImpl(dao)


}