package com.tictactoe;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navegador {

    public static <T> T mostrar(Stage stage, String rutaFxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(Navegador.class.getResource(rutaFxml));
        Parent raiz = loader.load();
        stage.setScene(new Scene(raiz));
        stage.sizeToScene();
        stage.centerOnScreen();
        return loader.getController();
    }
}