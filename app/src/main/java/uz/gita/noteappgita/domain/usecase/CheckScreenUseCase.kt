package uz.gita.noteappgita.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteappgita.data.model.CheckData

interface CheckScreenUseCase {
    fun insertCheckData(checkData: CheckData): Flow<Unit>
}