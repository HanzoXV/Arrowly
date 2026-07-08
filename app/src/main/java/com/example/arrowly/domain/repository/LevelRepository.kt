package com.example.arrowly.domain.repository

import com.example.arrowly.domain.model.Level

interface LevelRepository {
    suspend fun getLevel(levelId: Int): Level
}