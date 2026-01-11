package com.example.notassimples.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// DAO = Data Access Object
// Define as operações possíveis sobre a tabela "notas"
@Dao
interface NotasDao {

    // Observar todas as notas ordenadas pela mais recente.
    // Flow permite atualização automática da interface.
    @Query("SELECT * FROM notas ORDER BY atualizadoEm DESC")
    fun observarNotas(): Flow<List<NotaEntity>>

    // Guardar ou atualizar uma nota.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardar(nota: NotaEntity)

    // Apagar uma nota.
    @Delete
    suspend fun apagar(nota: NotaEntity)
}
