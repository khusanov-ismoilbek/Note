package uz.gita.noteappgita.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.gita.noteappgita.data.sources.AppDatabase
import uz.gita.noteappgita.data.sources.dao.CheckDao
import uz.gita.noteappgita.data.sources.dao.NoteDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalModule {

    @Provides
    @Singleton
    fun getNoteDatabase(@ApplicationContext context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "Notes")
            .fallbackToDestructiveMigration()
            .build()

    @[Provides Singleton]
    fun getNoteDao(database: AppDatabase): NoteDao = database.getNoteDao()

    @Provides
    @Singleton
    fun getCheckDao(database: AppDatabase): CheckDao = database.getCheckDao()
}