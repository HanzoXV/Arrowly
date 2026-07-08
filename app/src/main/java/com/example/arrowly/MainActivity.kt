package com.example.arrowly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.arrowly.presentation.game.GameScreen
import com.example.arrowly.presentation.levelselect.LevelSelectScreen
import com.example.arrowly.presentation.mainmenu.MainMenuScreen
import com.example.arrowly.presentation.screen.Screen
import com.example.arrowly.presentation.splash.SplashScreen
import com.example.arrowly.presentation.theme.ArrowlyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArrowlyTheme {
                ArrowlyNavHost()
            }
        }
    }
}

@Composable
fun ArrowlyNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(onTimeout = {
                navController.navigate(Screen.MainMenu.route) {
                    popUpTo(Screen.Splash.route) { inclusive = true }
                }
            })
        }

        composable(route = Screen.MainMenu.route) {
            MainMenuScreen(onPlayClick = {
                navController.navigate(Screen.Levels.route)
            })
        }

        composable(route = Screen.Levels.route) {
            LevelSelectScreen(onLevelClick = { levelId ->
                navController.navigate(Screen.Game.createRoute(levelId))
            })
        }

        composable(
            route = Screen.Game.route,
            arguments = listOf(navArgument("levelId") { type = NavType.IntType })
        ) { backStackEntry ->
            val levelId = backStackEntry.arguments?.getInt("levelId") ?: 1
            GameScreen(levelId = levelId)
        }
    }
}