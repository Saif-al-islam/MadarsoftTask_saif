package com.saif.madarsofttask_saif.di


import android.content.Context
import androidx.room.Room
import com.saif.madarsofttask_saif.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    fun provideUserLocalDB(@ApplicationContext appContext: Context): AppDatabase = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java, "db_Users"
    ).build()


}