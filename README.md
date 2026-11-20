# 🎮 TicTacToe (Gato) en JavaFX

Juego del Gato para dos jugadores desarrollado con **Java**, **JavaFX**, interfaces diseñadas en **Scene Builder** (FXML) y **Maven**. Con estética inspirada en Mario Bros.

Proyecto escolar de **Programación Orientada a Objetos**.

## 📑 Contenido

- [Características](#-características)
- [Tecnologías](#️-tecnologías)
- [Cómo ejecutarlo](#️-cómo-ejecutarlo)
- [Cómo jugar](#️-cómo-jugar)
- [Estructura del proyecto](#️-estructura-del-proyecto)
- [Conceptos de POO aplicados](#-conceptos-de-poo-aplicados)
- [Autor](#-autor)

## Características

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

## ▶️ Cómo ejecutarlo

### 1. Requisitos

| Qué | Versión | Para qué |
|---|---|---|
| [JDK (Temurin)](https://adoptium.net/) | **21** | Compilar y ejecutar Java |
| [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download/) | Cualquiera reciente | Abrir y ejecutar el proyecto |
| Conexión a internet | | Solo la primera vez, para descargar JavaFX |

> **No** necesitas instalar JavaFX ni Scene Builder: Maven descarga JavaFX automáticamente. Scene Builder solo sirve para editar visualmente los archivos `.fxml`.

### 2. Descargar el proyecto

- **Con Git:** `git clone https://github.com/TU_USUARIO/TicTacToe.git`
- **Sin Git:** en esta página pulsa el botón verde **Code > Download ZIP** y descomprime el archivo.

### 3. Abrirlo en IntelliJ IDEA

1. Abre IntelliJ y elige **Open**.
2. Selecciona la carpeta `TicTacToe` (la que contiene el archivo `pom.xml`).
3. Si pregunta si confías en el proyecto, pulsa **Trust Project**.
4. Espera a que termine la barra de progreso inferior: Maven está descargando JavaFX.

### 4. Configurar el JDK 21

1. Ve a **File > Project Structure > Project**.
2. En **SDK** elige un JDK 21. Si no aparece, usa **Download JDK**, versión **21**, vendor **Eclipse Temurin**.
3. Pulsa **OK**.

### 5. Ejecutar el juego

1. Abre el panel **Maven** (ícono con una "m", en el borde derecho).
2. Despliega `TicTacToe > Plugins > javafx`.
3. Haz **doble clic en `javafx:run`**.

Se abrirá la ventana del juego. La primera ejecución tarda un poco más porque descarga dependencias.

### Alternativa: desde la terminal

Si ya tienes Maven instalado, dentro de la carpeta del proyecto ejecuta:

```bash
mvn clean javafx:run
```

### ❓ Problemas frecuentes

| Problema | Solución |
|---|---|
| `Error: JavaFX runtime components are missing` | No uses el botón verde de "Run". Ejecuta `javafx:run` desde el panel Maven. |
| Errores en rojo en el código o imports de `javafx` | Pulsa **Reload All Maven Projects** (flechas circulares en el panel Maven). |
| Error de versión de Java o `release version 21 not supported` | El proyecto usa JDK 21: revisa el paso 4. |
| No aparece el panel Maven | Abre la carpeta que contiene `pom.xml`, no una subcarpeta. |
| Falla la descarga de dependencias | Revisa tu conexión a internet y vuelve a recargar Maven. |

## 🕹️ Cómo jugar

1. Escribe los nombres de ambos jugadores y pulsa **Comenzar**.
2. Por turnos, pulsen una casilla para colocar su símbolo.
3. Gana quien complete tres símbolos en línea. Si se llena el tablero sin ganador, es empate.
4. Usen **Revancha** para otra partida con los mismos jugadores, o **Nueva partida** para cambiarlos.

## 🗂️ Estructura del proyecto

```
TicTacToe
├── pom.xml
└── src/main
    ├── java/com/tictactoe
    │   ├── Main.java                  # Punto de entrada
    │   ├── Navegador.java             # Cambio entre pantallas
    │   ├── controller/
    │   │   ├── RegistroController.java
    │   │   └── JuegoController.java
    │   └── model/
    │       ├── Jugador.java
    │       ├── Tablero.java
    │       ├── Partida.java
    │       └── EstadoPartida.java
    └── resources/com/tictactoe
        ├── css/estilos.css
        └── view/
            ├── registro.fxml
            └── juego.fxml
```

El proyecto separa las responsabilidades en tres capas:

- **Modelo (`model`):** las reglas del juego, sin código de interfaz.
- **Vista (`view` y `css`):** archivos FXML y estilos.
- **Controlador (`controller`):** conecta las acciones del usuario con el modelo.

## 📚 Conceptos de POO aplicados

- **Encapsulamiento:** atributos privados con métodos de acceso.
- **Responsabilidad única:** cada clase se encarga de una sola tarea.
- **Composición:** `Partida` contiene un `Tablero` y dos `Jugador`.
- **Enumeraciones:** `EstadoPartida` representa el estado de la partida.

## 👤 Autor

**Jose Manuel Lara Villalobos**
