package com.example.arrowly.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.arrowly.data.local.entity.LevelProgressEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LevelProgressDao {
    @Query("SELECT * FROM level_progress WHERE levelId = :levelId")
    suspend fun getProgress(levelId: Int): LevelProgressEntity?

    @Query("SELECT * FROM level_progress")
    fun getAllProgress(): Flow<List<LevelProgressEntity>>

    @Upsert
    suspend fun upsert(progress: LevelProgressEntity)
}