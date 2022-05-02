# Linxo Gallery App

#Project
J'ai effectué ce project en environ 5h
Je me suis beaucoups attardé sur les parties back(network,data,business logic) et beaucoup moins sur les partie front(presenter,viewModel).
J'ai testé l'utilisation du jetpackCompose pour m'exercer et surtout je pense que ce choix est beaucoup plus adapté pour ce sujet qu'une recycler view complexe( adapter + view holder + recyclerview)

#Choix Technique
* Utilisation d'un repository afin d'avoir un SSOT
* Dependancy injection pour créer nos modules network
* Utilisation de coroutine combiné au flow afin d'avoir la possiblité de compute dans le futur des data sur different thread
* Moshi préféré à GSON car plus stable dans la gestion des élements nulls + plus adatpé au Kotlin
* Utilisation de Usecase renformant toute la busniess logic de notre application 
* MVVM + Clean architecture

#Problèmes non traités mais identifiés
* Utilisation de Ktor comme system de networking car beaucoup plus adapté au Kotlin
* Rajouter des tests unitaires en testant notamment les cas d'erreurs et le repository
* Meilleurs gestions des cas d'érrreurs(Pop up ou écran générique)
* Improvement de la UI en utilisant des styles et des thèmes( notamment la gestion des size et alignement en jetpack sont des éléments à encore approfondir pour moi)

#Ressenties
Je me suis sentie à l'aise sur toutes les parties malgré quelques problèmes, notamment la partie jetpack ou je ne suis pas du tout habitué 
je n'ai malheureusement pas pu faire tout ce que je voulais notamment développer des TU ou encore développer une UI beaucoup plus moderne en utilisant toutes les resources offertes par le jetpackcompose
  


