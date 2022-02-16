package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dao.UserDao
import com.example.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao

    }
