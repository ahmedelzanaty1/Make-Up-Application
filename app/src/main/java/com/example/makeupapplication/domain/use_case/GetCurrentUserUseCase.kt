package com.example.makeupapplication.domain.use_case

import com.example.makeupapplication.common.Resource
import com.example.makeupapplication.domain.repository.auth.AuthRepository
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class GetCurrentUserUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Resource<FirebaseUser?> {
        return authRepository.getCurrentUser()
    }

}