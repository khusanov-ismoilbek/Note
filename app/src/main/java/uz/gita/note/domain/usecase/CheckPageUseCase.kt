package uz.gita.note.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.note.data.model.CheckData

interface CheckPageUseCase {
    fun getAllCheck(): Flow<List<CheckData>>
    fun updateCheckBoxData(data: CheckData): Flow<Unit>
}