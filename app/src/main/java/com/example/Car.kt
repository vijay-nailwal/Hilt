package com.example

import com.example.util.LogUtil
import javax.inject.Inject


/**
 * Created by Vijay on 13-02-2022.
 */
class Car @Inject constructor(
    private val engine: Engine,
    private val wheel: Wheel
) {

    fun getCar() {
        engine.getEngine()
        wheel.getWheel()
        LogUtil.d("car name ")
    }
}