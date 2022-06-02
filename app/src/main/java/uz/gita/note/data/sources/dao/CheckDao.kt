package uz.gita.note.data.sources.dao

import androidx.room.*
import uz.gita.note.data.sources.entity.CheckEntity

@Dao
interface CheckDao {

    @Insert
    fun insertCheck(data: CheckEntity)

    @Update
    fun updateCheck(data: CheckEntity)

    @Delete
    fun deleteCheck(data: CheckEntity)

    @Query("SELECT * FROM CheckEntity WHERE CheckEntity.isDeleted == 0")
    fun getAllCheckData(): List<CheckEntity>

}