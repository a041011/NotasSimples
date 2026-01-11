package com.example.notassimples.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notassimples.data.local.NotaEntity
import com.example.notassimples.repo.RepositorioNotas
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

// ViewModel responsável pelas notas.
// Guarda o estado e a lógica usada pela interface.
class NotasViewModel(
    private val repositorio: RepositorioNotas
) : ViewModel() {

    // Lista de notas observada em tempo real.
    val notas: StateFlow<List<NotaEntity>> =
        repositorio.observarNotas().stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    // Criar nova nota.
    fun criarNota(titulo: String, conteudo: String) {
        viewModelScope.launch {
            repositorio.criarNota(titulo, conteudo)
        }
    }

    // Apagar nota.
    fun apagarNota(nota: NotaEntity) {
        viewModelScope.launch {
            repositorio.apagarNota(nota)
        }
    }
}
