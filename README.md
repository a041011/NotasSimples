# 📱 NotasSimples

Aplicação Android desenvolvida em Kotlin, utilizando Jetpack Compose, no âmbito da Unidade Curricular de Computação Móvel.


## **🎯 Objetivo**

A aplicação NotasSimples permite criar, visualizar e apagar notas guardadas localmente no dispositivo móvel.
Inclui ainda um ecrã adicional que acede à internet para apresentar uma “Frase do dia”, obtida a partir de uma API pública, cumprindo assim os requisitos de acesso online definidos para o trabalho.


## **✅ Requisitos cumpridos**

- Jetpack Compose – Interface gráfica declarativa

- Multi-ecrã – Navegação entre ecrãs com Navigation Compose

- Armazenamento local – Persistência de dados offline com Room

- Acesso à internet – Consumo de API REST com Retrofit


## **⚙️ Tecnologias utilizadas**

- Kotlin

- Jetpack Compose

- Room (base de dados local)

- Retrofit (comunicação HTTP)

- Moshi (conversão JSON → objetos Kotlin)

- Navigation Compose

- Arquitetura MVVM (ViewModel + State)


## 🧩 Funcionalidades
## **📝 Notas (offline)**

- Criar notas (título e conteúdo)

- Listar todas as notas guardadas

- Apagar notas

- As notas permanecem guardadas após fechar a aplicação, utilizando Room


## **🌐 Frase do dia (online)**

- Ecrã dedicado para apresentação da “Frase do dia”

- Obtenção de uma frase aleatória através de uma API pública

- Botão para atualizar a frase

- Tratamento de erros em caso de falha de ligação à internet


## **🗂️ Estrutura da aplicação**

A aplicação segue uma separação clara de responsabilidades:

- ui – Ecrãs desenvolvidos com Jetpack Compose

- viewmodel – Gestão de estado e lógica da aplicação (MVVM)

- data.local – Entidades, DAO e base de dados Room

- data.remote – Acesso à API externa

- repo – Repositórios para abstração das fontes de dados


## **⚠️ Limitações e melhorias futuras**

- A funcionalidade “Frase do dia” depende de ligação à internet

- Não existe autenticação de utilizadores

- Poderia ser adicionada sincronização na cloud (ex.: Firebase)

- Poderia ser melhorada a edição de notas existentes


## **📦 Entrega**

O código-fonte da aplicação encontra-se disponível neste repositório GitHub.
Este README serve como documentação da aplicação, explicando o seu funcionamento, tecnologias utilizadas e limitações conhecidas.
