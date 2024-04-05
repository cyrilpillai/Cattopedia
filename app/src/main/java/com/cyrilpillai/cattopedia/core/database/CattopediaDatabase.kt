package com.cyrilpillai.cattopedia.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cyrilpillai.cattopedia.core.database.dao.BreedDao
import com.cyrilpillai.cattopedia.core.database.entity.BreedEntity
import com.cyrilpillai.cattopedia.core.database.entity.BreedImageEntity

@Database(entities = [BreedEntity::class, BreedImageEntity::class], version = 1)
abstract class CattopediaDatabase : RoomDatabase() {
    abstract fun breedDao(): BreedDao
}