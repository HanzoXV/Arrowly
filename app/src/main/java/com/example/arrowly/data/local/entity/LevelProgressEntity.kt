package com.example.arrowly.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "level_progress")
data class LevelProgressEntity(
    @PrimaryKey val levelId: Int,
    val isCompleted: Boolean = false,
    val starsEarned: Int = 0,
    val droplets: Int = 3,
    val bestTimeMs: Long? = null,
    val completedAt: Long? = null
)