package br.senai.sp.jandira.tabuada;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {

    TextField textFieldMultiplicando;
    TextField textFieldMenorMultiplicador;
    TextField textFieldMaiorMultiplicador;
    ListView listaTabuada;

    @Override
    public void start(Stage stage) throws IOException {


        //Definindo o tamanho da tela
       stage.setWidth(350);
        stage.setHeight(650);
        
        //controlando o fechamento ao clicar no fechar da janela
        stage.setOnCloseRequest(e -> {
            e.consume();
            fechar();
        });

        //Bloquear o redimensionamento da janela
        stage.setResizable(false);


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
        gridFormulario.setPadding(new Insets(10,20,20,20));
        gridFormulario.setHgap(5);
        gridFormulario.setVgap(10);
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
        boxBotoes.setAlignment(Pos.CENTER);
        boxBotoes.setSpacing(8);
        boxBotoes.setPadding(new Insets(0,20,20,20));

        Button botaoCalcular = new Button("Calcular");
        botaoCalcular.setPrefWidth(85);
        botaoCalcular.setPrefHeight(40);
        botaoCalcular.setOnAction(e -> {
            System.out.println("CALCULANDO ...");
                CalcularTabuada();
        });
        Button botaoLimpar = new Button("Limpar");
        botaoLimpar.setPrefWidth(70);
        botaoLimpar.setPrefHeight(40);
        botaoLimpar.setOnAction(e -> {
            LimparTabuada();
            LimparFormulario();
        });
        Button botaoSair = new Button("Sair");
        botaoSair.setPrefWidth(70);
        botaoSair.setPrefHeight(40);
        botaoSair.setOnAction(e -> {
            fechar();
        });

        //Adicionar os botoes na box botoes
        boxBotoes.getChildren().addAll(botaoCalcular, botaoLimpar, botaoSair);


        //Adicionar um componente ListView (no caso a lista de calculados)
        VBox boxResultado = new VBox();
        boxResultado.setPadding(new Insets(10,20,20,20));
        Label labelResultado = new Label("Resultado: ");
        labelResultado.setPadding(new Insets(0,10,5,0));
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

    public void fechar(){
            Alert alertaFechar = new Alert(
                    Alert.AlertType.CONFIRMATION, "Confirma a saída do sistema?",
                    ButtonType.YES,
                    ButtonType.NO
            );
            Optional<ButtonType> resposta = alertaFechar.showAndWait();
            if (resposta.isPresent() && resposta.get() == ButtonType.YES) {
                Platform.exit();
            }
    }
    public void LimparFormulario(){
        textFieldMultiplicando.setText("");
        textFieldMenorMultiplicador.setText("");
        textFieldMaiorMultiplicador.setText("");
        listaTabuada.getItems().clear();
        textFieldMultiplicando.requestFocus();

    }



    public void CalcularTabuada() {
        int multiplicando = Integer.parseInt(textFieldMultiplicando.getText());
        int menorMultiplicador = Integer.parseInt(textFieldMenorMultiplicador.getText());
        int maiorMultiplicador = Integer.parseInt(textFieldMaiorMultiplicador.getText());


        if (maiorMultiplicador < menorMultiplicador) {
            int auxiliar = menorMultiplicador;
            menorMultiplicador = maiorMultiplicador;
            maiorMultiplicador = auxiliar;

        }
        int tamanho = maiorMultiplicador - menorMultiplicador + 1;
        String[] tabuada = new String[tamanho];



        int contador = 0;
        while (contador < tamanho) {
            int produto = multiplicando * menorMultiplicador;
            tabuada[contador] = multiplicando + "x" + menorMultiplicador + "=" + produto;
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
