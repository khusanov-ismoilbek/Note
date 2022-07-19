package uz.gita.noteappgita.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteappgita.data.model.CheckData

interface EditCheckScreenUseCase {
    fun updateCheckData(data: CheckData): Flow<Unit>
    fun deleteCheckData(data: CheckData): Flow<Unit>
}