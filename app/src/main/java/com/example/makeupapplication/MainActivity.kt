package com.example.makeupapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.makeupapplication.common.Destinations
import com.example.makeupapplication.presentation.screens.home.HomeScreen
import com.example.makeupapplication.presentation.screens.intro.IntroScreen
import com.example.makeupapplication.presentation.screens.login.LoginScreen
import com.example.makeupapplication.presentation.screens.signup.SignupScreen
import com.example.makeupapplication.presentation.screens.splash.SplashScreen
import com.example.makeupapplication.ui.theme.MakeupApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MakeupApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavGraph(modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun NavGraph(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destinations.SPLASH,

    ) {
        composable(Destinations.SPLASH) {
            SplashScreen(navController = navController)
        }
        composable(Destinations.INTRO) {
            IntroScreen(navController = navController)
        }
        composable(Destinations.LOGIN) {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Destinations.HOME)
                },
                navController = navController
            )
        }
        composable(Destinations.REGISTER) {
            SignupScreen(navController = navController , onSignSuccess = {
                navController.navigate(Destinations.HOME)
            })
        }
        composable(Destinations.HOME) {
            HomeScreen()
        }

    }

}

