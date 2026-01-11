package com.example.notassimples.repo

import com.example.notassimples.data.local.NotaEntity
import com.example.notassimples.data.local.NotasDao
import kotlinx.coroutines.flow.Flow

// Repositório: camada intermédia entre o ViewModel e o Room.
// O ViewModel não fala diretamente com o DAO.
class RepositorioNotas(
    private val notasDao: NotasDao
) {

    // Observar todas as notas guardadas na base de dados.
    fun observarNotas(): Flow<List<NotaEntity>> {
        return notasDao.observarNotas()
    }

    // Criar uma nova nota.
    suspend fun criarNota(titulo: String, conteudo: String) {
        val agora = System.currentTimeMillis()

        val nota = NotaEntity(
            titulo = titulo,
            conteudo = conteudo,
            atualizadoEm = agora
        )

        notasDao.guardar(nota)
    }

    // Apagar uma nota existente.
    suspend fun apagarNota(nota: NotaEntity) {
        notasDao.apagar(nota)
    }
}
