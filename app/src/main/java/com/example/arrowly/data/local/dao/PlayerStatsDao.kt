package com.example.arrowly.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.arrowly.data.local.entity.PlayerStatsEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PlayerStatsDao {
    @Query("SELECT * FROM player_stats WHERE id = 0")
    fun observeStats(): Flow<PlayerStatsEntity?>

    @Upsert
    suspend fun upsert(stats: PlayerStatsEntity)
}