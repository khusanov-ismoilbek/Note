package uz.gita.noteappgita.domain.usecase.impl

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.noteappgita.data.model.CheckData
import uz.gita.noteappgita.data.sources.entity.CheckEntity
import uz.gita.noteappgita.domain.repository.AppRepository
import uz.gita.noteappgita.domain.usecase.CheckPageUseCase
import uz.gita.noteappgita.utils.toCheckData
import javax.inject.Inject

class CheckPageUseCaseImpl @Inject constructor(val appRepository: AppRepository) :
    CheckPageUseCase {
    override fun getAllCheck(): Flow<List<CheckData>> = flow {
        val list = appRepository.getAllCheck().map {
            it.toCheckData()
        }
        emit(list)
    }.flowOn(Dispatchers.IO)

    override fun updateCheckBoxData(data: CheckData): Flow<Unit> = flow {
        val newData = appRepository.updateCheck(
            CheckEntity(
                data.id,
                data.checkText,
                data.time,
                data.isDeleted,
                data.isPinned,
                data.state
            )
        )
        Log.d("QQQ", data.toString())
        emit(newData)
    }.flowOn(Dispatchers.IO)
}