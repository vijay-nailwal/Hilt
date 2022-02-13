package com.example

import com.example.util.LogUtil
import javax.inject.Inject


/**
 * Created by Vijay on 13-02-2022.
 */
class Wheel {
    @Inject
    constructor()

    fun getWheel(){
        LogUtil.d("wheel name ")
    }
}