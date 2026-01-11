package com.example.notassimples.data.remote

// DTO da ZenQuotes.
// A API devolve um array com objetos que têm:
// q = frase, a = autor
data class FraseDto(
    val q: String,
    val a: String
)


