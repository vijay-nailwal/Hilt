package com.example.di

import android.content.Context
import androidx.room.Room
import com.example.dao.UserDao
import com.example.database.UserDatabase
import com.example.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule  {

    @Provides
    fun providesUserDao(userDatabase: UserDatabase): UserDao = userDatabase.userDao()

    @Provides
    @Singleton
    fun providesUserDatabase(@ApplicationContext context: Context): UserDatabase
            = Room.databaseBuilder(context, UserDatabase::class.java,"UserDatabase").build()

    @Provides
    fun providesUserRepository(userDao: UserDao) : UserRepository
            = UserRepository(userDao)
}