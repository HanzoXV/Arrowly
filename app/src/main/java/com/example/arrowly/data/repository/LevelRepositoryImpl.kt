package com.example.arrowly.data.repository

import com.example.arrowly.domain.model.Difficulty
import com.example.arrowly.domain.model.IntSize
import com.example.arrowly.domain.model.Level
import com.example.arrowly.domain.repository.LevelRepository
import jakarta.inject.Inject

class LevelRepositoryImpl @Inject constructor() : LevelRepository {

    override suspend fun getLevel(levelId: Int): Level {
        return Level(
            id = levelId,
            difficulty = Difficulty.Easy,
            gridSize = IntSize(width = 6, height = 6),
            arrows = emptyList()
        )
    }
}