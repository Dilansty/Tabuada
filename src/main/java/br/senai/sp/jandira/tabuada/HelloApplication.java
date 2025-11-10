package br.senai.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class HelloApplication extends Application {

    TextField textFieldMultiplicando;
    TextField textFieldMenorMultiplicador;
    TextField textFieldMaiorMultiplicador;
    ListView listaTabuada;

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

        Label labelTitulo = new Label("Tabuada");
        labelTitulo.setStyle("-fx-text-fill: white;-fx-font-size: 22;-fx-font-weight: bold;");


        //Subtitulo
        Label labelSubtitulo = new Label("construa a tabuada sem limites!");
        labelSubtitulo.setStyle("-fx-text-fill: white;-fx-font-weight: bold;-fx-font-size: 14;");
        header.getChildren().add(labelTitulo);
        header.getChildren().add(labelSubtitulo);


        //Criar o multiplicando
        GridPane gridFormulario = new GridPane();
        Label labelMultiplicando = new Label("Multiplicando: ");
        textFieldMultiplicando = new TextField();

        gridFormulario.add(labelMultiplicando, 0, 0);
        gridFormulario.add(textFieldMultiplicando, 1, 0);


        //Criar Menor multiplicador
        Label labelMenorMultiplicador = new Label("Menor Multiplicador: ");
        textFieldMenorMultiplicador = new TextField();

        gridFormulario.add(labelMenorMultiplicador, 0, 1);
        gridFormulario.add(textFieldMenorMultiplicador, 1, 1);


        //Criar Maior multiplicador
        Label labelMaiorMultiplicador = new Label("Maior Multiplicador: ");
        textFieldMaiorMultiplicador = new TextField();

        gridFormulario.add(labelMaiorMultiplicador, 0, 2);
        gridFormulario.add(textFieldMaiorMultiplicador, 1, 2);


        //Criar o componente de Botôes
        HBox boxBotoes = new HBox();

        Button botaoCalcular = new Button("Calcular");
        botaoCalcular.setOnAction(e -> {
            System.out.println("CALCULANDO ...");
                CalcularTabuada();
        });

        Button botaoLimpar = new Button("Limpar");
        botaoLimpar.setOnAction(e -> {
            LimparTabuada();
        });
        Button botaoSair = new Button("Sair");

        //Adicionar os botoes na box botoes
        boxBotoes.getChildren().addAll(botaoCalcular, botaoLimpar, botaoSair);


        //Adicionar um componente ListView (no caso a lista de calculados)
        VBox boxResultado = new VBox();
        Label labelResultado = new Label("Resultado: ");
        labelResultado.setStyle("-fx-text-fill: #02288a; -fx-font-size: 14; -fx-font-weight: bold");

        listaTabuada = new ListView();



        //Adicionar itens do resultado na boxResultado
        boxResultado.getChildren().addAll(labelResultado, listaTabuada);


        //Adicionar componentetes ao root
        root.getChildren().add(header);
        root.getChildren().add(gridFormulario);
        root.getChildren().add(boxBotoes);
        root.getChildren().add(boxResultado);

//        Criar o multiplicador minimo
//        HBox multiplicadorMin = new HBox();
//        Label labelMultiplicadorMin = new Label("Multiplicador Mínimo: ");
//        TextField textFieldMultiplicadorMin = new TextField();


    }
    public void CalcularTabuada(){
        int multiplicando = Integer.parseInt(textFieldMultiplicando.getText());
        int menorMultiplicador = Integer.parseInt(textFieldMenorMultiplicador.getText());
        int maiorMultiplicador = Integer.parseInt(textFieldMaiorMultiplicador.getText());

        int tamanho = maiorMultiplicador - menorMultiplicador + 1;
        String[] tabuada = new String[tamanho];

        int contador = 0;
        while(contador < tamanho){
            int produto = multiplicando * menorMultiplicador;
            tabuada[contador] = multiplicando + "x" +  menorMultiplicador + "=" + produto;
            contador++;
            menorMultiplicador++;
        }
        listaTabuada.getItems().clear();
        listaTabuada.getItems().addAll(tabuada);


    }
    public void LimparTabuada(){
        listaTabuada.getItems().clear();
    }
}
