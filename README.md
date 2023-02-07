# Pokédex App

Aplicativo para pesquisa dos seus Pokémons favoritos.
Desenvolvido em Kotlin para Android.



## Funcionalidades

- Pesquisa por Pokémons através do ID registrado em [PokeAPI](https://pokeapi.co/) ou nome do Pokémons
- Opção de visualizar um Pokémon aleatório clicando no botão da página inicial
- Página com informações do Pokémon, como: imagem, peso (em kg), altura (em cm), tipos...
- Opção de visualizar todos os Pokémons de um tipo (em construção)

## Arquitetura do projeto




## Libs utilizadas

* UI: 
    * [Jetpack Compose](https://developer.android.com/jetpack/compose) - Todos os componentes de UI e navegação foram desenvolvidos utilizando o Jetpack
    * [Material Design 3](https://m3.material.io/) - Design System da Google
    * [Coil](https://coil-kt.github.io/coil/compose/) - Carrega imagens da web em componentes compose

* Network:
    * [Retrofit](https://square.github.io/retrofit/) - Cliente HTTP
    * [PokeAPI](https://pokeapi.co/) - API de consumo dos dados de Pokémons

* Outros:
    * [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) - Para execuções assíncronas
    * [GSON](https://github.com/square/retrofit/tree/master/retrofit-converters/gson) - Conversão de JSON para objetos Kotlin
