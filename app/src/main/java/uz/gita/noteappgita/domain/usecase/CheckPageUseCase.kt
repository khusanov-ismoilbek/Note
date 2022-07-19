package uz.gita.noteappgita.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteappgita.data.model.CheckData

interface CheckPageUseCase {
    fun getAllCheck(): Flow<List<CheckData>>
    fun updateCheckBoxData(data: CheckData): Flow<Unit>
}