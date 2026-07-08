package com.example.arrowly.domain.model

data class LevelProgress(
    val levelId: Int,
    val isCompleted: Boolean = false,
    val starsEarned: Int = 0,
    val droplets: Int = 3,
    val bestTimeMs: Long? = null,
    val completedAt: Long? = null
)