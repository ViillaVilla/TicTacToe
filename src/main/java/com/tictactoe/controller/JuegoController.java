package com.tictactoe.controller;

import com.tictactoe.Navegador;
import com.tictactoe.model.Jugador;
import com.tictactoe.model.Partida;
import com.tictactoe.model.Tablero;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import com.tictactoe.model.EstadoPartida;

import java.io.IOException;

public class JuegoController {

    @FXML private Label lblJugadores;
    @FXML private Label lblEstado;
    @FXML private GridPane tablero;

    private Partida partida;

    /** El RegistroController llama a este método al abrir la pantalla. */
    public void iniciar(Jugador jugador1, Jugador jugador2) {
        partida = new Partida(jugador1, jugador2);
        lblJugadores.setText(jugador1.getNombre() + " (X)  vs  " + jugador2.getNombre() + " (O)");
        actualizarVista();
    }

    @FXML
    private void casillaPulsada(ActionEvent evento) {
        Button boton = (Button) evento.getSource();
        int fila = indice(GridPane.getRowIndex(boton));
        int columna = indice(GridPane.getColumnIndex(boton));

        if (partida.jugar(fila, columna)) {
            actualizarVista();
        }
    }

    @FXML
    private void reiniciar() {
        partida.reiniciar();
        actualizarVista();
    }

    @FXML
    private void nuevaPartida() {
        try {
            Stage stage = (Stage) tablero.getScene().getWindow();
            Navegador.mostrar(stage, "/com/tictactoe/view/registro.fxml");
        } catch (IOException e) {
            lblEstado.setText("No se pudo volver al registro.");
        }
    }

    private void actualizarVista() {
        for (Node nodo : tablero.getChildren()) {
            Button boton = (Button) nodo;
            int fila = indice(GridPane.getRowIndex(boton));
            int columna = indice(GridPane.getColumnIndex(boton));
            char simbolo = partida.getSimboloEn(fila, columna);

            boton.setText(simbolo == Tablero.VACIA ? "" : String.valueOf(simbolo));
            boton.getStyleClass().removeAll("casilla-x", "casilla-o", "casilla-ganadora");
            if (simbolo == 'X') {
                boton.getStyleClass().add("casilla-x");
            } else if (simbolo == 'O') {
                boton.getStyleClass().add("casilla-o");
            }
            if (esGanadora(fila, columna)) {
                boton.getStyleClass().add("casilla-ganadora");
            }
        }

        switch (partida.getEstado()) {
            case EN_CURSO -> lblEstado.setText("Turno de " + partida.getTurnoActual().getNombre()
                    + " (" + partida.getTurnoActual().getSimbolo() + ")");
            case GANADOR -> lblEstado.setText("¡Ganó " + partida.getGanador().getNombre() + "!");
            case EMPATE -> lblEstado.setText("¡Empate!");
        }
    }

    private boolean esGanadora(int fila, int columna) {
        if (partida.getEstado() != EstadoPartida.GANADOR) {
            return false;
        }
        for (int[] celda : partida.getLineaGanadora()) {
            if (celda[0] == fila && celda[1] == columna) {
                return true;
            }
        }
        return false;
    }

    // GridPane devuelve null para la fila/columna 0 si no se fijó; lo tratamos como 0.
    private int indice(Integer valor) {
        return valor == null ? 0 : valor;
    }
}