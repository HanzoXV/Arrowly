package com.example.arrowly.presentation.levelselect

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.items
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun LevelSelectScreen(
    onLevelClick: (Int) -> Unit,
    viewModel: LevelSelectViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.isLoading) return

    val visibleLevels = 1..(uiState.currentLevel + 2)

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(visibleLevels.toList()) { levelId ->
            val state = computeLevelState(levelId, uiState.currentLevel)
            LevelListItem(
                levelId = levelId,
                state = state,
                onClick = { if (state != LevelState.LOCKED) onLevelClick(levelId) }
            )
        }
    }
}

fun computeLevelState(levelId: Int, currentLevel: Int): LevelState = when {
    levelId < currentLevel -> LevelState.COMPLETED
    levelId == currentLevel -> LevelState.CURRENT
    else -> LevelState.LOCKED
}
@Composable
private fun LevelListItem(
    levelId: Int,
    state: LevelState,
    onClick: () -> Unit
) {
    val backgroundColor = when (state) {
        LevelState.COMPLETED -> Color(0xFFFFC107)
        LevelState.CURRENT -> Color(0xFF2196F3)
        LevelState.LOCKED -> Color(0xFF757575)
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .clickable(enabled = state != LevelState.LOCKED, onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Level $levelId",
            color = Color.White,
            style = MaterialTheme.typography.titleMedium
        )
    }
}
