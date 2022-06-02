package uz.gita.note.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.note.data.model.CheckData

interface CheckScreenUseCase {
    fun insertCheckData(checkData: CheckData): Flow<Unit>
}