package com.example.notassimples.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notassimples.viewmodel.EstadoFrase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcraFrase(
    estado: EstadoFrase,
    aoAtualizar: () -> Unit,
    aoVoltar: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Frase do dia") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(12.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = aoAtualizar) { Text("Atualizar") }
                OutlinedButton(onClick = aoVoltar) { Text("Voltar") }
            }

            if (estado.aCarregar) {
                CircularProgressIndicator()
            }

            estado.erro?.let {
                Text(it, color = MaterialTheme.colorScheme.error)
            }

            if (estado.frase.isNotBlank()) {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(12.dp)) {
                        Text("“${estado.frase}”", style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(8.dp))
                        Text("- ${estado.autor}")
                    }
                }
            } else if (!estado.aCarregar && estado.erro == null) {
                Text("Carrega em Atualizar para obter uma frase da internet.")
            }
        }
    }
}

