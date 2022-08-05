package com.example.timer.data.storage.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope


@Database(entities = arrayOf(Time::class), version = 1, exportSchema = false)
abstract class TimerDatabase: RoomDatabase() {
    abstract fun timeDao(): TimeDao

    companion object{

        @Volatile
        private var INSTANCE: TimerDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): TimerDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TimerDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}