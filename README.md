# NotasSimples

Aplicação Android desenvolvida em Kotlin com Jetpack Compose para a UC de Computação Móvel.

## Objetivo
A aplicação permite criar, visualizar e apagar notas guardadas localmente no dispositivo e inclui um ecrã adicional que obtém uma “Frase do dia” a partir de uma API pública (acesso à internet).

## Requisitos cumpridos
- **Jetpack Compose** (UI)
- **Multi-ecrã** (Navigation Compose)
- **Armazenamento local** com **Room**
- **Acesso à internet** com **Retrofit** (API ZenQuotes)

## Funcionalidades
### Notas (offline)
- Criar nota (título e conteúdo)
- Listar notas guardadas
- Apagar notas
- As notas permanecem guardadas após fechar a aplicação (Room)

### Frase do dia (online)
- Obter frase motivacional e autor a partir da internet
- Botão “Atualizar” para pedir uma nova frase
- Tratamento de erros (ex.: sem internet)

## Como executar
1. Abrir o projeto no Android Studio
2. Sincronizar Gradle (Sync)
3. Executar em emulador ou dispositivo Android (Run)

## Estrutura do projeto (resumo)
- `data/local` → Room (Entity, DAO, Database)
- `repo` → Repositório (camada entre dados e ViewModel)
- `viewmodel` → ViewModels (estado e lógica)
- `ui/screens` → Ecrãs Compose

## Limitações
- Sem autenticação de utilizadores
- Interface simples, focada em demonstrar os requisitos
- A funcionalidade “Frase do dia” depende de ligação à internet

## Credenciais
Não são necessárias credenciais/contas para usar a aplicação.
