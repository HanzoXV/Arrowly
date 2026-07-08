package com.example.arrowly.domain.model

data class Level(
    val id: Int,
    val difficulty: Difficulty,
    val gridSize: IntSize,
    val arrows: List<ArrowPiece>
)