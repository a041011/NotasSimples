package com.example.notassimples.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// Esta classe representa uma Nota na base de dados local (Room).
// Cada objeto desta classe corresponde a uma linha na tabela "notas".
@Entity(tableName = "notas")
data class NotaEntity(

    // Identificador único da nota.
    // autoGenerate = true faz com que o Room gere o ID automaticamente.
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    // Título da nota.
    val titulo: String,

    // Conteúdo da nota.
    val conteudo: String,

    // Data/hora da última atualização (em milissegundos).
    val atualizadoEm: Long
)