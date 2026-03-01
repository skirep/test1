# NEBULA FORCE (Android)

Prototip jugable d'un shoot'em up retro 16-bit per Android, implementat amb **Kotlin + Jetpack Compose**.

## Què inclou ara

- App Android en format vertical.
- Control tàctil per arrossegar la nau del jugador.
- Dispar automàtic del jugador (simulat amb dany continu al cap).
- Sistema bàsic de projectils enemics i col·lisions.
- 6 caps finals (un per nivell) amb HP, velocitat de bala i ritme de patró diferents.
- UI mínima de vida del cap, vida del jugador i estat de combat.

## Framework triat

- **Jetpack Compose** (sense engine extern), perquè és ràpid de prototipar i fàcil d'estendre cap a una versió completa.

## Estructura

- `app/src/main/java/com/nebula/force/MainActivity.kt`: entrada de l'app.
- `app/src/main/java/com/nebula/force/GameData.kt`: definició dels 6 caps.
- `app/src/main/java/com/nebula/force/GameScreen.kt`: loop de joc, render i input tàctil.

## Com executar

1. Obre la carpeta en Android Studio.
2. Sincronitza Gradle.
3. Executa `app` en un emulador o dispositiu Android.

## Full de ruta (següent pas)

- Afegir sprites pixel art reals i animacions per fases.
- Separar patrons per cap (espiral, ventall, radial, etc.).
- Implementar habilitats (bomba/dash) i invulnerabilitat temporal.
- Sistema de puntuació, checkpoints i progressió.
- Àudio chiptune/FM i efectes de so retro.


## CI (GitHub Actions)

Aquest repositori inclou el workflow `.github/workflows/android-apk.yml` que:

- compila `:app:assembleDebug` i `:app:assembleRelease`,
- i publica els APKs com artifacts de la run (`nebula-force-debug-apk` i `nebula-force-release-apk-unsigned`).
