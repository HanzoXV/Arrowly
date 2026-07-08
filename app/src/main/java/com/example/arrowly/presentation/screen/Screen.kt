package com.example.arrowly.presentation.screen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object MainMenu : Screen("mainmenu")
    object Levels : Screen("levels")
    object Game : Screen("game/{levelId}") {
        fun createRoute(levelId: Int) = "game/$levelId"
    }
}