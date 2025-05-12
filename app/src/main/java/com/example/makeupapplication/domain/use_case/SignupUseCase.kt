package com.example.makeupapplication.domain.use_case

import com.example.makeupapplication.common.Resource
import com.example.makeupapplication.domain.repository.auth.AuthRepository
import javax.inject.Inject

class SignupUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String, onResult: (Resource<Unit>) -> Unit) {
        authRepository.signUp(email, password, onResult)
    }
}