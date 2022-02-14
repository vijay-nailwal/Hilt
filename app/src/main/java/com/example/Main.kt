package com.example

import android.content.Context
import android.widget.Toast
import com.example.util.LogUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    private val lName: String,
    @ApplicationContext
    val context: Context) {
    fun getName() {
        LogUtil.d("name is $fName $lName")
        Toast.makeText(context, "ApplicationContext", Toast.LENGTH_SHORT).show()
    }
}

@Module
@InstallIn(SingletonComponent::class)
class ModuleApp {

    @Provides
    @FName
//    fun getFName(): String = "Vijay"
    fun getFName(): String = MainActivity.fName

    @Provides
    @LName
//    fun getLName(): String = "Nailwal"
    fun getLName(): String = MainActivity.fLame
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LName

