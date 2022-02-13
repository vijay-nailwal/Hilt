package com.example

import com.example.util.LogUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier


/**
 * Created by Vijay on 13-02-2022.
 */

class Main @Inject constructor(
    @FName
    private val fName: String,

    @LName
    private val lName: String) {
    fun getName() {
        LogUtil.d("name is $fName $lName")
    }
}

@Module
@InstallIn(SingletonComponent::class)
class ModuleApp {

    @Provides
    @FName
    fun getFName(): String = "Vijay"

    @Provides
    @LName
    fun getLName(): String = "Nailwal"
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LName

