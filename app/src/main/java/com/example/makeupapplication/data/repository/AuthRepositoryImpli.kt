package com.example.makeupapplication.data.repository

import com.example.makeupapplication.common.Resource
import com.example.makeupapplication.data.auth.FireBaseDataSource
import com.example.makeupapplication.domain.repository.auth.AuthRepository
import com.google.firebase.auth.FirebaseUser
import javax.inject.Inject

class AuthRepositoryImpli @Inject constructor(
    private val dataSource: FireBaseDataSource
): AuthRepository {
    override suspend fun signUp(
        email: String,
        password: String,
        onResult: (Resource<Unit>) -> Unit
    ) {
        dataSource.signUp(email, password, onResult)
    }

    override suspend fun login(
        email: String,
        password: String,
        onResult: (Resource<Unit>) -> Unit
    ) {
        dataSource.login(email, password, onResult)
    }

    override suspend fun getCurrentUser(): Resource<FirebaseUser?> {
        return dataSource.getCurrentUser()
    }
}