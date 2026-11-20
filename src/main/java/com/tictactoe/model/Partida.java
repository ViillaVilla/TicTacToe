package com.tictactoe.model;

public class Partida {

    private final Jugador jugador1;
    private final Jugador jugador2;
    private final Tablero tablero = new Tablero();
    private int[][] lineaGanadora;

    private Jugador turnoActual;
    private Jugador ganador;
    private EstadoPartida estado;

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        reiniciar();
    }

    public void reiniciar() {
        tablero.limpiar();
        turnoActual = jugador1;
        ganador = null;
        lineaGanadora = null;
        estado = EstadoPartida.EN_CURSO;
    }

    /** Devuelve true si la jugada se realizó; false si la casilla está ocupada o la partida terminó. */
    public boolean jugar(int fila, int columna) {
        if (estado != EstadoPartida.EN_CURSO) {
            return false;
        }
        if (!tablero.colocar(fila, columna, turnoActual.getSimbolo())) {
            return false;
        }

        int[][] linea = tablero.obtenerLinea(turnoActual.getSimbolo());
        if (linea != null) {
            lineaGanadora = linea;
            ganador = turnoActual;
            estado = EstadoPartida.GANADOR;
        } else if (tablero.estaLleno()) {
            estado = EstadoPartida.EMPATE;
        } else {
            turnoActual = (turnoActual == jugador1) ? jugador2 : jugador1;
        }
        return true;
    }

    public char getSimboloEn(int fila, int columna) {
        return tablero.getCelda(fila, columna);
    }

    public Jugador getTurnoActual() {
        return turnoActual;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public EstadoPartida getEstado() {
        return estado;
    }

    public int[][] getLineaGanadora() {
        return lineaGanadora;
    }
}