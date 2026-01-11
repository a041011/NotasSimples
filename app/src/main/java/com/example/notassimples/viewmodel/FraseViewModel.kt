package com.example.notassimples.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notassimples.data.remote.FrasesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Estado do ecrã da frase (simples e fácil de explicar)
data class EstadoFrase(
    val aCarregar: Boolean = false,
    val frase: String = "",
    val autor: String = "",
    val erro: String? = null
)

// ViewModel responsável por ir buscar a frase à internet
class FraseViewModel : ViewModel() {

    // Criar Retrofit com Gson (converter JSON -> Kotlin)
    private val api: FrasesApi = Retrofit.Builder()
        .baseUrl("https://zenquotes.io/api/") // tem de terminar com "/"
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(FrasesApi::class.java)

    private val _estado = MutableStateFlow(EstadoFrase())
    val estado: StateFlow<EstadoFrase> = _estado

    // Vai buscar uma frase à internet
    fun atualizar() {
        viewModelScope.launch {
            _estado.value = EstadoFrase(aCarregar = true)

            try {
                val lista = api.obterFraseAleatoria()
                // A ZenQuotes devolve uma lista com 1 elemento
                val dto = lista.first()
                _estado.value = EstadoFrase(
                    aCarregar = false,
                    frase = dto.q,
                    autor = dto.a
                )
            } catch (e: Exception) {
                _estado.value = EstadoFrase(
                    aCarregar = false,
                    erro = "Erro: ${e.javaClass.simpleName} - ${e.message}"
                )
            }
        }
    }
}

