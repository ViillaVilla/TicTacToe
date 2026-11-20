# 🎮 TicTacToe (Gato) en JavaFX

Juego del Gato para dos jugadores desarrollado con **Java**, **JavaFX**, interfaces diseñadas en **Scene Builder** (FXML) y **Maven**. Con estética inspirada en Mario Bros.

Proyecto escolar de **Programación Orientada a Objetos**.

##  Características

- Registro de dos jugadores: no permite nombres vacíos ni repetidos.
- Tablero de 3x3: Jugador 1 con **X** y Jugador 2 con **O**.
- Turnos alternados, con el nombre del jugador en turno siempre visible.
- No permite elegir casillas ocupadas ni jugar después de terminar la partida.
- Detecta victoria en filas, columnas y diagonales, y resalta la línea ganadora.
- Detecta empate.
- **Revancha:** reinicia el tablero conservando los nombres.
- **Nueva partida:** regresa al registro para cambiar de jugadores.

## 🛠️ Tecnologías

Java 21 · JavaFX 21 · FXML y Scene Builder · CSS · Maven

## 🗂️ Estructura

```
src/main
├── java/com/tictactoe
│   ├── Main.java
│   ├── Navegador.java
│   ├── controller/   (RegistroController, JuegoController)
│   └── model/        (Jugador, Tablero, Partida, EstadoPartida)
└── resources/com/tictactoe
    ├── css/estilos.css
    └── view/         (registro.fxml, juego.fxml)
```

El proyecto separa **modelo** (reglas del juego), **vista** (FXML y CSS) y **controlador** (conecta ambos).

## ▶️ Cómo ejecutarlo

Requisitos: **JDK 21** e **IntelliJ IDEA** (o cualquier IDE con Maven). La primera vez se necesita internet para descargar JavaFX.

1. Clona el repositorio y ábrelo con **File > Open**.
2. Espera a que Maven descargue las dependencias.
3. En el panel **Maven**, ejecuta `TicTacToe > Plugins > javafx > javafx:run`.

O desde la terminal, dentro de la carpeta del proyecto:

```bash
mvn clean javafx:run
```

## 👤 Autor

**Jose Manuel Lara Villalobos**
