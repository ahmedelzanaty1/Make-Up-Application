package com.example.makeupapplication.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.makeupapplication.R
import com.example.makeupapplication.common.Destinations
import com.example.makeupapplication.presentation.viewmodel.spalsh.SplashViewModel
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: SplashViewModel = hiltViewModel()
) {
    val state by viewModel.state

    LaunchedEffect(state) {
        when (state) {
            is SplashViewModel.SplashState.Authenticated -> {
                navController.navigate(Destinations.HOME) {
                    popUpTo("splash") { inclusive = true }
                }
            }
            is SplashViewModel.SplashState.NotAuthenticated -> {
                navController.navigate("login") {
                    popUpTo("splash") { inclusive = true }
                }
            }
            else -> {
                // Still Loading: do nothing
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.splash_back),
                contentScale = ContentScale.Crop
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.spalsh_bg),
                    contentScale = ContentScale.Crop
                ),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sign_bg),
                    contentDescription = "Logo",
                    modifier = Modifier.fillMaxWidth(.6f),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}
