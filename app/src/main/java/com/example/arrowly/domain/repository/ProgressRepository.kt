package com.example.arrowly.domain.repository

import com.example.arrowly.domain.model.LevelProgress
import com.example.arrowly.domain.model.PlayerStats
import kotlinx.coroutines.flow.Flow

interface ProgressRepository {
    suspend fun getLevelProgress(levelId: Int): LevelProgress?
    fun observeAllProgress(): Flow<List<LevelProgress>>
    suspend fun saveLevelProgress(progress: LevelProgress)

    fun observePlayerStats(): Flow<PlayerStats>
    suspend fun setCurrentLevel(levelId: Int)
}