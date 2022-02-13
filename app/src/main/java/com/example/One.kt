package com.example

import com.example.util.LogUtil
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Vijay on 13-02-2022.
 */

interface One {
    fun getName()
}

class ImplementOne @Inject constructor() : One {
    override fun getName() {
        LogUtil.d("get name ")
    }
}

class Main @Inject constructor(private val one: One) {
    fun getName() {
        one.getName()
    }
}


//recommended approach coz less Boilerplate
@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {
    @Binds
    @Singleton
    abstract fun binding(implementOne: ImplementOne):One
}

//not recommended approach coz more Boilerplate
/*
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun binding():One=ImplementOne()
}*/
