package com.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent raiz = FXMLLoader.load(getClass().getResource("/com/tictactoe/view/registro.fxml"));
        stage.setTitle("TicTacToe");
        stage.setScene(new Scene(raiz));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}