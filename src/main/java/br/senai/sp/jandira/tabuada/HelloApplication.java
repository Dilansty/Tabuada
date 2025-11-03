package br.senai.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        //Definindo o tamanho da tela
        stage.setWidth(500);
        stage.setHeight(650);


        //Componente principal da tela
        VBox root = new VBox();
        Scene scene = new Scene(root);
        root.setStyle("-fx-background-color: #aee9ff");
        stage.setScene(scene);
        stage.setTitle("Tabuada");
        stage.show();


        //Cabeçalho da tela
        //Titulo
        VBox header = new VBox();
        header.setStyle("-fx-padding: 10;-fx-background-color: #21b8e8");
        root.getChildren().add(header);
        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setStyle("-fx-text-fill: white;-fx-font-size: 22;-fx-font-weight: bold;");
        //Subtitulo
        Label labelSubtitulo = new Label("construa tabuada sem limites!");
        labelSubtitulo.setStyle("-fx-text-fill: white;-fx-font-weight: bold;-fx-font-size: 14;");
        header.getChildren().add(labelTitulo);
        header.getChildren().add(labelSubtitulo);

        //Criar o multiplicando
        HBox multiplicandoBox = new HBox();
        multiplicandoBox.setStyle("-fx-label-padding: 10");
        Label labelMultiplicando = new Label("Multiplicando: ");
        TextField textFieldMultiplicando = new TextField();
        multiplicandoBox.getChildren().add(labelMultiplicando);
        multiplicandoBox.getChildren().add(textFieldMultiplicando);
        //colocando o multiplicando box no root
        root.getChildren().add(multiplicandoBox);

        //Criar o multiplicador minimo
        HBox multiplicadorMin = new HBox();
        Label labelMultiplicadorMin = new Label("Multiplicador Mínimo: ");
        TextField textFieldMultiplicadorMin = new TextField();


    }
}
