package uz.gita.note.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.note.data.model.CheckData

interface EditCheckScreenUseCase {
    fun updateCheckData(data: CheckData): Flow<Unit>
    fun deleteCheckData(data: CheckData): Flow<Unit>
}