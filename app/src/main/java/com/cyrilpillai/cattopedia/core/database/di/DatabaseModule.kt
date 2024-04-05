package com.cyrilpillai.cattopedia.core.database.di

import android.content.Context
import androidx.room.Room
import com.cyrilpillai.cattopedia.core.database.CattopediaDatabase
import com.cyrilpillai.cattopedia.core.database.dao.BreedDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val DATABASE_NAME = "cattopedia-db"

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext applicationContext: Context
    ): CattopediaDatabase = Room.databaseBuilder(
        applicationContext,
        CattopediaDatabase::class.java, DATABASE_NAME
    ).build()

    @Provides
    fun provideBreedDao(appDatabase: CattopediaDatabase): BreedDao {
        return appDatabase.breedDao()
    }
}
