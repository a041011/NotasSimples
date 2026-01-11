package com.example.notassimples.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Ecrã simples para criar uma nota com campos.
// (Mais tarde podemos adaptar para editar também.)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EcraEditarNota(
    aoGuardar: (titulo: String, conteudo: String) -> Unit,
    aoVoltar: () -> Unit
) {
    var titulo by remember { mutableStateOf("") }
    var conteudo by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Nova nota") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(12.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = titulo,
                onValueChange = { titulo = it },
                label = { Text("Título") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = conteudo,
                onValueChange = { conteudo = it },
                label = { Text("Conteúdo") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(
                    onClick = {
                        aoGuardar(titulo, conteudo)
                        aoVoltar()
                    },
                    enabled = titulo.isNotBlank()
                ) { Text("Guardar") }

                OutlinedButton(onClick = aoVoltar) { Text("Cancelar") }
            }
        }
    }
}

