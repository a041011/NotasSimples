package com.example.notassimples.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notassimples.data.local.NotaEntity

// Este ecrã mostra a lista de notas.
// Também tem um botão "+" para criar uma nova nota.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcraListaNotas(
    notas: List<NotaEntity>,
    aoCriarNota: () -> Unit,
    aoApagarNota: (NotaEntity) -> Unit,
    aoAbrirFrase: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Notas") },
                actions = {
                    TextButton(onClick = aoAbrirFrase) {
                        Text("Frase")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = aoCriarNota) {
                Text("+")
            }
        }
    ) { paddingValues ->

        // Se não houver notas, mostramos uma mensagem simples.
        if (notas.isEmpty()) {
            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Ainda não tens notas.")
            }
        } else {
            // Lista de notas
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                contentPadding = PaddingValues(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(notas) { nota ->
                    Card(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Text(
                                text = nota.titulo,
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            val excerto = if (nota.conteudo.length > 80) {
                                nota.conteudo.take(80) + "…"
                            } else {
                                nota.conteudo
                            }

                            Text(text = excerto)

                            Spacer(modifier = Modifier.height(8.dp))

                            TextButton(onClick = { aoApagarNota(nota) }) {
                                Text("Apagar")
                            }
                        }
                    }
                }
            }
        }
    }
}


