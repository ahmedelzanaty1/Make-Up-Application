package com.example.makeupapplication.domain.repository.auth

import com.example.makeupapplication.common.Resource
import com.google.firebase.auth.FirebaseUser

interface AuthRepository {
    suspend fun signUp(email: String, password: String, onResult: (Resource<Unit>) -> Unit)
    suspend fun login(email: String, password: String, onResult: (Resource<Unit>) -> Unit)
    suspend fun getCurrentUser(): Resource<FirebaseUser?>
}
