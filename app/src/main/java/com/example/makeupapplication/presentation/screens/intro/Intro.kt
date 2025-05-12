package com.example.makeupapplication.presentation.screens.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.makeupapplication.R
import com.example.makeupapplication.common.Destinations

@Composable
fun IntroScreen(modifier: Modifier = Modifier , navController: NavController) {
   Column(modifier = modifier.fillMaxSize()) {
       Column(modifier = Modifier
           .fillMaxWidth()
           .heightIn(200.dp)) {
           Image(
               painter = painterResource(id = R.drawable.intro_bg),
               contentDescription = "Logo", modifier = Modifier.fillMaxWidth(),
               contentScale = ContentScale.Crop
           )
       }
       Column(modifier = Modifier.fillMaxWidth()) {
           Text(
               text = "Explore the wide range of cosmetic product only in fashio store's",
               fontSize = 20.sp,
               modifier = Modifier.fillMaxWidth().padding(25.dp)
           )
           Spacer(modifier = Modifier.height(10.dp))
           Button(onClick = {
               navController.navigate(Destinations.LOGIN)
           }, modifier = Modifier.padding(20.dp).fillMaxWidth(.4f)
               , colors = ButtonDefaults.buttonColors(Color.Black)
           ) {
               Text(
                   text = "Login",
                   fontSize = 15.sp,
                   color = Color.White
               )
           }
           Text(
               text = "or Sign Up",
               fontSize = 20.sp,
               modifier = Modifier.fillMaxWidth().padding(20.dp).clickable {
                   navController.navigate(Destinations.REGISTER)
               }

           )

       }
   }
}

