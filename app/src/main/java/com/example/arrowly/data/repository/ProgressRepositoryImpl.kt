package com.example.arrowly.data.repository

import com.example.arrowly.data.local.dao.LevelProgressDao
import com.example.arrowly.data.local.dao.PlayerStatsDao
import com.example.arrowly.data.local.entity.PlayerStatsEntity
import com.example.arrowly.data.mapper.toDomain
import com.example.arrowly.data.mapper.toEntity
import com.example.arrowly.domain.model.LevelProgress
import com.example.arrowly.domain.model.PlayerStats
import com.example.arrowly.domain.repository.ProgressRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ProgressRepositoryImpl @Inject constructor(
    private val levelProgressDao: LevelProgressDao,
    private val playerStatsDao: PlayerStatsDao
) : ProgressRepository {

    override suspend fun getLevelProgress(levelId: Int): LevelProgress? =
        levelProgressDao.getProgress(levelId)?.toDomain()

    override fun observeAllProgress(): Flow<List<LevelProgress>> =
        levelProgressDao.observeAllProgress().map { list -> list.map { it.toDomain() } }

    override suspend fun saveLevelProgress(progress: LevelProgress) =
        levelProgressDao.upsert(progress.toEntity())

    override fun observePlayerStats(): Flow<PlayerStats> =
        playerStatsDao.observeStats().map { it?.toDomain() ?: PlayerStats(currentLevel = 1) }

    override suspend fun setCurrentLevel(levelId: Int) {
        playerStatsDao.upsert(PlayerStatsEntity(currentLevel = levelId))
    }
}