package com.example.madlevel5task2.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "gameTable")
class Game(

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "platform")
    var platform: String,

    @ColumnInfo(name = "release")
    var release: Date,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
)