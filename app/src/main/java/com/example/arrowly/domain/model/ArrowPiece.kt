package com.example.arrowly.domain.model

data class ArrowPiece(
    val id: Int,
    val cells: List<Point>,
    val direction: Direction
) {
    val head: Point get() = cells.first()
    val tail: Point get() = cells.last()
}