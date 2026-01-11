package com.example.notassimples.data.remote

import retrofit2.http.GET

// Interface Retrofit para ir buscar uma frase motivacional (ZenQuotes).
interface FrasesApi {

    // O endpoint devolve um ARRAY com 1 objeto.
    @GET("random")
    suspend fun obterFraseAleatoria(): List<FraseDto>
}



