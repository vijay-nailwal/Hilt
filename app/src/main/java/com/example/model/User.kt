package com.example.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import javax.inject.Inject

@Entity(tableName = "user")
data class User constructor(val textViewName:String, val textViewAge:Int) {
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
}