package com.example.makeupapplication.presentation.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.makeupapplication.R
import com.example.makeupapplication.presentation.screens.login.viewmodel.LoginViewModel
import com.example.makeupapplication.presentation.screens.signup.ViewModel.SignupViewModel


@Composable
fun SignupScreen(
    onSignSuccess: () -> Unit,
    navController: NavController,
    viewModel: SignupViewModel = hiltViewModel()
) {

    val state = viewModel.state.value

    LaunchedEffect(state.signupSuccess) {
        if (state.signupSuccess) {
            onSignSuccess()
        }
    }
    Column (modifier = Modifier
        .fillMaxSize()
        .paint(
            painter = painterResource(R.drawable.auth_bg),
            contentScale = ContentScale.Crop
        )){
        Row (modifier = Modifier.padding(15.dp).fillMaxWidth() ,
            horizontalArrangement = Arrangement.Center){
            Image(
                painter = painterResource(id = R.drawable.fashion),
                contentDescription = "Logo",
                alignment = Alignment.Center
            )
            Image(
                painter = painterResource(id = R.drawable.back_ic),
                contentDescription = "Logo",
                alignment = Alignment.TopStart
            )
        }
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp), color = Color.White
        )
        Column (modifier = Modifier.fillMaxSize() , horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            OutlinedTextField(
                value = state.email,
                onValueChange = viewModel::onEmailChange,
                label = { Text("Email") },
                isError = state.emailError != null,
                modifier = Modifier.fillMaxWidth()
            )
            if (state.emailError != null) {
                Text(
                    text = state.emailError,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.align(Alignment.Start)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Password field
            OutlinedTextField(
                value = state.password,
                onValueChange = viewModel::onPasswordChange,
                label = { Text("Password") },
                isError = state.passwordError != null,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            if (state.passwordError != null) {
                Text(
                    text = state.passwordError,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = viewModel::signUp,
                modifier = Modifier.fillMaxWidth(),
                enabled = !state.isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White , contentColor = Color.Black)
            ) {
                if (state.isLoading) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                } else {
                    Text("Login")
                }
            }
            state.errorMessage?.let { message ->
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = message,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
            }

        }
    }


}