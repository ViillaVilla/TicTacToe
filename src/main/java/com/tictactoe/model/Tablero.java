package com.tictactoe.model;

import java.util.Arrays;

public class Tablero {

    public static final int TAMANO = 3;
    public static final char VACIA = ' ';

    private final char[][] celdas = new char[TAMANO][TAMANO];

    public Tablero() {
        limpiar();
    }

    public void limpiar() {
        for (char[] fila : celdas) {
            Arrays.fill(fila, VACIA);
        }
    }

    public char getCelda(int fila, int columna) {
        return celdas[fila][columna];
    }

    public boolean colocar(int fila, int columna, char simbolo) {
        if (celdas[fila][columna] != VACIA) {
            return false;
        }
        celdas[fila][columna] = simbolo;
        return true;
    }

    public boolean estaLleno() {
        for (char[] fila : celdas) {
            for (char celda : fila) {
                if (celda == VACIA) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] obtenerLinea(char s) {
        for (int i = 0; i < TAMANO; i++) {
            if (celdas[i][0] == s && celdas[i][1] == s && celdas[i][2] == s) {
                return new int[][]{{i, 0}, {i, 1}, {i, 2}}; // fila
            }
            if (celdas[0][i] == s && celdas[1][i] == s && celdas[2][i] == s) {
                return new int[][]{{0, i}, {1, i}, {2, i}}; // columna
            }
        }
        if (celdas[0][0] == s && celdas[1][1] == s && celdas[2][2] == s) {
            return new int[][]{{0, 0}, {1, 1}, {2, 2}}; // diagonal principal
        }
        if (celdas[0][2] == s && celdas[1][1] == s && celdas[2][0] == s) {
            return new int[][]{{0, 2}, {1, 1}, {2, 0}}; // diagonal inversa
        }
        return null; // no hay línea
    }
}