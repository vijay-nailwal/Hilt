package com.example

import com.example.util.LogUtil
import javax.inject.Inject


/**
 * Created by Vijay on 13-02-2022.
 */
class Car {
    @Inject
    constructor()

    fun getCarName() {
        LogUtil.d("car is running")
    }
}