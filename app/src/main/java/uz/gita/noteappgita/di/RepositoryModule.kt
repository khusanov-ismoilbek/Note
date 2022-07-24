package uz.gita.noteappgita.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.noteappgita.domain.repository.AppRepository
import uz.gita.noteappgita.domain.repository.impl.AppRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun getRepository(impl: AppRepositoryImpl): AppRepository

}