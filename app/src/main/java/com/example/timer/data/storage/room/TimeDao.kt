package com.example.timer.data.storage.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TimeDao {

    @Query("SELECT * FROM timer_table ")
    fun getListTime(): Flow<List<Time>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(time: Time)

    @Query("DELETE FROM timer_table")
    suspend fun deleteAll()

}