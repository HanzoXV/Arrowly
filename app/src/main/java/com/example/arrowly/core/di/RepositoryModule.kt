package com.example.arrowly.core.di

import com.example.arrowly.data.repository.LevelRepositoryImpl
import com.example.arrowly.data.repository.ProgressRepositoryImpl
import com.example.arrowly.domain.repository.LevelRepository
import com.example.arrowly.domain.repository.ProgressRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindProgressRepository(impl: ProgressRepositoryImpl): ProgressRepository

    @Binds
    abstract fun bindLevelRepository(impl: LevelRepositoryImpl): LevelRepository
}