package com.example

import com.example.util.LogUtil
import javax.inject.Inject


/**
 * Created by Vijay on 13-02-2022.
 */
class Engine {
    @Inject
    constructor()

    fun getEngine(){
        LogUtil.d("engine name ")
    }
}