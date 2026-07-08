package com.example.arrowly.data.mapper

import com.example.arrowly.data.local.entity.PlayerStatsEntity
import com.example.arrowly.domain.model.PlayerStats

fun PlayerStatsEntity.toDomain(): PlayerStats =
    PlayerStats(currentLevel = currentLevel)

fun PlayerStats.toEntity(): PlayerStatsEntity =
    PlayerStatsEntity(currentLevel = currentLevel)