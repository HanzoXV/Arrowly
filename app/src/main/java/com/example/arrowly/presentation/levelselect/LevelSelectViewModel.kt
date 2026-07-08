package com.example.arrowly.presentation.levelselect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.arrowly.domain.repository.ProgressRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class LevelSelectViewModel @Inject constructor(
    private val progressRepository: ProgressRepository
) : ViewModel() {

    val uiState: StateFlow<LevelSelectUiState> = progressRepository
        .observePlayerStats()
        .map { stats -> LevelSelectUiState(currentLevel = stats.currentLevel, isLoading = false) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = LevelSelectUiState()
        )
}