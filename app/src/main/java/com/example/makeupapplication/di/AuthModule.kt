package com.example.makeupapplication.di

import com.example.makeupapplication.data.auth.FireBaseDataSource
import com.example.makeupapplication.data.repository.AuthRepositoryImpli
import com.example.makeupapplication.domain.repository.auth.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
    @Provides
    @Singleton
    fun provideFirebaseDataSource(firebaseAuth: FirebaseAuth): FireBaseDataSource {
        return FireBaseDataSource(firebaseAuth)
    }
    @Provides
    @Singleton
    fun provideAuthRepository(firebaseDataSource: FireBaseDataSource): AuthRepository {
        return AuthRepositoryImpli(firebaseDataSource)
    }
}