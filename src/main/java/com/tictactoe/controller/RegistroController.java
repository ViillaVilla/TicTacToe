package com.tictactoe.controller;

import com.tictactoe.Navegador;
import com.tictactoe.model.Jugador;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroController {

    @FXML private TextField txtJugador1;
    @FXML private TextField txtJugador2;
    @FXML private Label lblError;

    @FXML
    private void limpiar() {
        txtJugador1.clear();
        txtJugador2.clear();
        lblError.setText("");
        txtJugador1.requestFocus();
    }

    @FXML
    private void comenzar() {
        String nombre1 = txtJugador1.getText().trim();
        String nombre2 = txtJugador2.getText().trim();

        if (nombre1.isEmpty() || nombre2.isEmpty()) {
            mostrarError("Los dos nombres son obligatorios.");
            return;
        }

        if (nombre1.equalsIgnoreCase(nombre2)) {
            mostrarError("Los nombres no pueden ser iguales.");
            return;
        }

        Jugador jugador1 = new Jugador(nombre1, 'X');
        Jugador jugador2 = new Jugador(nombre2, 'O');

        try {
            Stage stage = (Stage) txtJugador1.getScene().getWindow();
            JuegoController juego = Navegador.mostrar(stage, "/com/tictactoe/view/juego.fxml");
            juego.iniciar(jugador1, jugador2);
        } catch (IOException e) {
            mostrarError("No se pudo abrir la pantalla del juego.");
        }
    }

    private void mostrarError(String mensaje) {
        lblError.setText(mensaje);
    }
}