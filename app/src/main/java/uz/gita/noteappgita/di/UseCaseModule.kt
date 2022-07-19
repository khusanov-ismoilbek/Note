package uz.gita.noteappgita.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.noteappgita.domain.usecase.*
import uz.gita.noteappgita.domain.usecase.impl.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {

    @Binds
    @Singleton
    fun getNoteScreenUseCase(impl: NoteScreenUseCaseImpl): NoteScreenUseCae

    @Binds
    @Singleton
    fun getNotePageUseCase(impl: NotePageUseCaseImpl): NotePageUseCase

    @Binds
    @Singleton
    fun getEditScreenUseCase(impl: EditNoteScreenUseCaseImpl): EditNoteScreenUseCase


    @Binds
    @Singleton
    fun getCheckPageUseCase(impl: CheckPageUseCaseImpl): CheckPageUseCase

    @Binds
    @Singleton
    fun getCheckScreenUseCase(impl: CheckScreenUseCaseImpl): CheckScreenUseCase

    @Binds
    @Singleton
    fun getEditCheckScreenUseCase(impl: EditCheckScreenUseCaseImpl): EditCheckScreenUseCase
}