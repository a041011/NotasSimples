package com.example.notassimples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.notassimples.data.local.AppDb
import com.example.notassimples.repo.RepositorioNotas
import com.example.notassimples.ui.screens.EcraEditarNota
import com.example.notassimples.ui.screens.EcraFrase
import com.example.notassimples.ui.screens.EcraListaNotas
import com.example.notassimples.ui.theme.NotasSimplesTheme
import com.example.notassimples.viewmodel.FraseViewModel
import com.example.notassimples.viewmodel.NotasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = Room.databaseBuilder(
            applicationContext,
            AppDb::class.java,
            "notas.db"
        ).build()

        val repositorio = RepositorioNotas(db.notasDao())
        val notasVM = NotasViewModel(repositorio)
        val fraseVM = FraseViewModel() // vamos criar já a seguir

        setContent {
            NotasSimplesTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "lista") {

                    composable("lista") {
                        val notas by notasVM.notas.collectAsState()

                        EcraListaNotas(
                            notas = notas,
                            aoCriarNota = { navController.navigate("nova") },
                            aoApagarNota = { notasVM.apagarNota(it) },
                            aoAbrirFrase = { navController.navigate("frase") }
                        )
                    }

                    composable("nova") {
                        EcraEditarNota(
                            aoGuardar = { titulo, conteudo ->
                                notasVM.criarNota(titulo, conteudo)
                            },
                            aoVoltar = { navController.popBackStack() }
                        )
                    }

                    composable("frase") {
                        EcraFrase(
                            estado = fraseVM.estado.collectAsState().value,
                            aoAtualizar = { fraseVM.atualizar() },
                            aoVoltar = { navController.popBackStack() }
                        )
                    }
                }
            }
        }
    }
}

