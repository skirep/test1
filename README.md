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
# NEBULA FORCE – Joc Android retro 16-bit

Aquest document defineix **NEBULA FORCE** com a joc d’**Android** amb identitat arcade pura (1992–1995), adaptat a pantalla tàctil.

## Visió de producte (Android)

- **Plataforma objectiu:** Android 10+.
- **Format principal:** vertical (9:16), pensat per joc amb una mà + dispar automàtic.
- **Sessió típica:** 8–15 minuts.
- **Loop:** nivells curts + cap final + recompenses + millores lleugeres.
- **Estil visual:** pixel art 16-bit, contrast alt i lectura immediata en mòbil.
- **Audio:** FM/chiptune/synth 90s, temes curts i memorables.

## Controls tàctils recomanats

- **Moviment:** joystick virtual a l’esquerra.
- **Dispar:** automàtic per mantenir ritme arcade.
- **Habilitat especial (bomba):** botó gran a la dreta (cooldown visible).
- **Dash/evadir:** segon botó a la dreta (invulnerabilitat curta).
- **UI:** text gran, vides/energia visibles, feedback de dany molt clar.

## Regles de disseny per Android

- Patrons llegibles en pantalles petites (evitar soroll visual innecessari).
- Projectils amb siluetes i colors molt diferenciats.
- Dificultat exigent però justa (espais reals entre bales).
- Durada de caps controlada per evitar fatiga de polze.
- Rendiment estable: objectiu **60 FPS** en gamma mitjana.

---

## NIVELL 1 – FRONTERA DE RUNA
### CAP: TYRAX-01 SENTINEL CORE

**Aspecte retro**
- Sprite gran en 3 parts: anell exterior, anell interior i nucli.
- Colors: gris metàl·lic + vermell intermitent.
- Rotació simple en 8 frames.
- Fons amb estrelles que parpellegen.

**Mecàniques**
- Dispar circular lent (bales blaves rodones).
- Ràfega directa de 5 projectils.
- A mitja vida, trencament de l’anell exterior (canvi de sprite).

**Dificultat (Android)**
- Baixa-mitjana.
- Patrons lents i memoritzables.
- Vida: 60–80 impactes estàndard.
- Durada: 1,5–2 minuts.

**Música**
- Chiptune espacial alegre però tens.
- Baix FM marcat, melodia heroica, ritme moderat.

## NIVELL 2 – MAR DE SORRA
### CAP: VOR’KETH, LA REINA DUNA

**Aspecte retro**
- Aranya pixelada amb 6 potes rígides.
- Mandíbules amb animació de 4 frames.
- Ous com sprites petits als laterals.
- Colors: marró, taronja i groc sorra.

**Mecàniques**
- 3 files de projectils en ventall.
- Spawn d’aranyes petites en línia recta.
- Salt lateral predefinit en 3 posicions.

**Dificultat (Android)**
- Mitjana.
- Pressió constant per spawn d’enemics petits.
- Vida: 100–120 impactes.
- Durada: 2–3 minuts.

**Música**
- Chiptune amb percussió tribal simulada.
- Ritme més ràpid, baix sec, melodia enganxosa.

## NIVELL 3 – RUÏNES SOTERRADES
### CAP: HELIOX-PRIME

**Aspecte retro**
- Cara robòtica flotant estil clàssic.
- Escut hexagonal amb parpelleig.
- Canvi de paleta en fase 2.
- Colors: blau elèctric + blanc brillant.

**Mecàniques**
- Patró en espiral lent.
- Línies rectes creuades en forma d’X.
- Escut frontal: només rep mal per darrere en certs moments.

**Dificultat (Android)**
- Mitjana-alta.
- Requereix posicionament precís.
- Vida: 140 impactes.
- Durada: 3 minuts.

**Música**
- Electro retro minimalista.
- Ritme mecànic constant, melodia hipnòtica.

## NIVELL 4 – TEMPESTA IONITZADA
### CAP: KRAION COLOSSUS

**Aspecte retro**
- Robot gegant segmentat.
- Peces que parpellegen en rebre mal.
- Fase 2: divisió en 2 sprites més petits.
- Colors: blau, gris i llampecs blancs.

**Mecàniques**
- Llampecs verticals.
- Ones de projectils lents.
- Fase 2 amb dos mini-caps simultanis.

**Dificultat (Android)**
- Alta.
- Pantalla més plena de projectils.
- Vida total: 180 impactes.
- Durada: 3–4 minuts.

**Música**
- Chiptune ràpid amb bateria marcada.
- Arpegis ràpids i sensació de perill imminent.

## NIVELL 5 – CORREDOR ESTEL·LAR
### CAP: ORYX DUAL CORE

**Aspecte retro**
- Dues esferes unides per un feix d’energia.
- Parpelleig constant tipus glitch limitat.
- En destruir-ne una, l’altra canvia de color.
- Colors: porpra i verd neó.

**Mecàniques**
- Reutilitza patrons anteriors però més ràpid.
- Dispar alternat entre les dues esferes.
- Fase final amb pluja radial de projectils petits.

**Dificultat (Android)**
- Molt alta.
- Velocitat augmentada.
- Vida: 200 impactes.
- Durada: 4 minuts.

**Música**
- Chiptune ràpid estil final stage.
- BPM elevat, melodia heroica intensa, FM agressiu.

## NIVELL 6 – COR DE NÀQIRA
### CAP FINAL: REINA NÀQIRA – FINAL FORM

**Aspecte retro**
- Sprite enorme ocupant mitja pantalla.
- Fase 1: aranya mecànica negra amb nucli vermell.
- Fase 2: nucli flotant amb flames pixelades.
- Explosió final amb anell expandint-se.

**Mecàniques**
- Fase 1: làsers diagonals, eixams petits, onada en forma de U.
- Fase 2: patró dens tipus bullet-hell amb espais justos.
- Acceleració progressiva a l’últim tram.

**Dificultat (Android)**
- Extrema (final arcade pur).
- Pensat per jugadors que han memoritzat patrons.
- Vida total: 250+ impactes.
- Durada: 5 minuts.

**Música**
- Tema final 16-bit èpic.
- Intro dramàtica, secció ràpida intensa, tornada heroica i final triomfal.

---

## Notes tècniques mínimes (Android)

- Objectiu de latència d’input baix en dispositius de gamma mitjana.
- Pool d’objectes per projectils/enemics (evitar GC spikes).
- Escalat pixel-perfect opcional amb mode “nítid” i mode “suau”.
- Vibració curta en impacte greu i derrota de cap.
- Guardat local de progrés + configuració d’àudio i controls.
