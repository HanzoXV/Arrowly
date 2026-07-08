package com.example.arrowly.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.arrowly.data.local.dao.LevelProgressDao
import com.example.arrowly.data.local.dao.PlayerStatsDao
import com.example.arrowly.data.local.entity.LevelProgressEntity
import com.example.arrowly.data.local.entity.PlayerStatsEntity

@Database(
    entities = [LevelProgressEntity::class, PlayerStatsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ArrowlyDatabase : RoomDatabase() {
    abstract fun levelProgressDao(): LevelProgressDao
    abstract fun playerStatsDao(): PlayerStatsDao
}