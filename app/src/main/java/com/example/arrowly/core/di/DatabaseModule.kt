package com.example.arrowly.core.di

import android.content.Context
import androidx.room.Room
import com.example.arrowly.data.local.ArrowlyDatabase
import com.example.arrowly.data.local.dao.LevelProgressDao
import com.example.arrowly.data.local.dao.PlayerStatsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ArrowlyDatabase =
        Room.databaseBuilder(context, ArrowlyDatabase::class.java, "arrowly.db").build()

    @Provides
    fun provideLevelProgressDao(db: ArrowlyDatabase): LevelProgressDao = db.levelProgressDao()

    @Provides
    fun providePlayerStatsDao(db: ArrowlyDatabase): PlayerStatsDao = db.playerStatsDao()
}