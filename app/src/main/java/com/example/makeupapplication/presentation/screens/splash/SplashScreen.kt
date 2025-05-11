package com.example.makeupapplication.presentation.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.makeupapplication.R
import com.example.makeupapplication.common.Destinations
import com.example.makeupapplication.presentation.viewmodel.spalsh.SplashViewModel

@Composable
fun SplashScreen(modifier: Modifier = Modifier , navController: NavController ,
                 viewModel: SplashViewModel = hiltViewModel()) {
    val splashFinished by viewModel.splashFinished.collectAsState()
    LaunchedEffect(splashFinished) {
        if (splashFinished) {
            navController.navigate("intro") {
                popUpTo("splash") { inclusive = true }
            }
        }
    }
    Column (modifier = modifier
        .fillMaxSize()
        .paint(
            painter = painterResource(id = R.drawable.splash_back),
            contentScale = ContentScale.Crop
        ), verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally){
        Column (Modifier.fillMaxSize().paint(
            painter = painterResource(id = R.drawable.spalsh_bg),
            contentScale = ContentScale.Crop
        ),
            verticalArrangement = Arrangement.Center
        ){
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
             ) {
            Image(
                painter = painterResource(id = R.drawable.sign_bg),
                contentDescription = "Logo", modifier = Modifier.fillMaxWidth(.6f),
                contentScale = ContentScale.Crop
            )
        }
        }
    }
    
}

@Preview(showBackground = true)
@Composable
private fun Spalsh() {
    SplashScreen(navController = NavController(LocalContext.current))

}