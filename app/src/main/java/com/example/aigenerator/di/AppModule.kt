package com.example.aigenerator.di

import android.app.Application
import com.example.aigenerator.data.datastore.PreferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePreferencesDataStore(application: Application): PreferencesDataStore =
        PreferencesDataStore(application)
}