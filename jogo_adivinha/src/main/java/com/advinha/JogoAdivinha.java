package com.advinha;
import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JogoAdivinha extends Application {

    private int numeroSecreto;
    private int tentativas;

    private Label lblTentativas;
    private Label lblResultado;
    private TextField txtPalpite;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Inicialização do número secreto e tentativas
        reiniciarJogo();

        // Configuração da interface
        Label lblTitulo = new Label("Jogo do Adivinha");
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        lblTentativas = new Label("Tentativas: 0");

        txtPalpite = new TextField();
        txtPalpite.setPromptText("Digite seu palpite...");
        txtPalpite.setMaxWidth(200);

        Button btnVerificar = new Button("Verificar");
        btnVerificar.setOnAction(e -> verificarPalpite());

        Button btnDica = new Button("Dica (Custa 2 tentativas)");
        btnDica.setOnAction(e -> mostrarDica());

        lblResultado = new Label();
        lblResultado.setStyle("-fx-text-fill: blue;");

        Button btnReiniciar = new Button("Reiniciar Jogo");
        btnReiniciar.setOnAction(e -> reiniciarJogo());

        // Layout
        VBox layout = new VBox(10, lblTitulo, lblTentativas, txtPalpite, btnVerificar, btnDica, lblResultado, btnReiniciar);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20px;");

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Jogo do Adivinha");
        primaryStage.show();
    }

    private void reiniciarJogo() {
        Random random = new Random();
        numeroSecreto = random.nextInt(1001); // Número aleatório entre 0 e 1000
        tentativas = 0;
        if (lblTentativas != null) lblTentativas.setText("Tentativas: " + tentativas);
        if (lblResultado != null) lblResultado.setText("");
        if (txtPalpite != null) txtPalpite.clear();
    }

    private void verificarPalpite() {
        try {
            int palpite = Integer.parseInt(txtPalpite.getText());
            tentativas++;
            lblTentativas.setText("Tentativas: " + tentativas);

            if (palpite < numeroSecreto) {
                lblResultado.setText("O número secreto é maior!");
            } else if (palpite > numeroSecreto) {
                lblResultado.setText("O número secreto é menor!");
            } else {
                lblResultado.setText("Parabéns! Você acertou!");
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Fim de Jogo");
                alerta.setHeaderText(null);
                alerta.setContentText("Você acertou em " + tentativas + " tentativas!");
                alerta.showAndWait();
                reiniciarJogo();
            }
        } catch (NumberFormatException e) {
            Alert erro = new Alert(Alert.AlertType.ERROR);
            erro.setTitle("Erro");
            erro.setHeaderText(null);
            erro.setContentText("Por favor, insira um número válido.");
            erro.showAndWait();
        }
    }

    private void mostrarDica() {
        tentativas += 2;
        lblTentativas.setText("Tentativas: " + tentativas);
        String paridade = (numeroSecreto % 2 == 0) ? "par" : "ímpar";
        lblResultado.setText("Dica: O número é " + paridade + ".");
    }
}
