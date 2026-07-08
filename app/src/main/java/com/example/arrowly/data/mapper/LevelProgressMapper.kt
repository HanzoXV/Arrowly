package com.example.arrowly.data.mapper

import com.example.arrowly.data.local.entity.LevelProgressEntity
import com.example.arrowly.domain.model.LevelProgress

fun LevelProgressEntity.toDomain(): LevelProgress =
    LevelProgress(
        levelId = levelId,
        isCompleted = isCompleted,
        starsEarned = starsEarned,
        bestTimeMs = bestTimeMs,
        completedAt = completedAt,
        droplets = droplets
    )

fun LevelProgress.toEntity(): LevelProgressEntity =
    LevelProgressEntity(
        levelId = levelId,
        isCompleted = isCompleted,
        starsEarned = starsEarned,
        bestTimeMs = bestTimeMs,
        completedAt = completedAt,
        droplets = droplets
    )