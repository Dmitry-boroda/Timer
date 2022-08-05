package com.example.timer.data.storage.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "timer_table")
data class Time(@PrimaryKey @ColumnInfo(name = "time")val time: String)
