package com.advinha;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class JogoAdivinhaController {

    private int numeroSecreto;
    private int tentativas;

    @FXML
    private Label lblTentativas;

    @FXML
    private Label lblResultado;

    @FXML
    private TextField txtPalpite;

    @FXML
    private Button btnVerificar;

    @FXML
    private Button btnDica;

    @FXML
    private Button btnReiniciar;

    @FXML
    private void initialize() {
        // Método chamado automaticamente ao carregar o FXML
        reiniciarJogo();
    }

    @FXML
    private void verificarPalpite() {
        try {
            int palpite = Integer.parseInt(txtPalpite.getText());
            tentativas++;
            lblTentativas.setText("Tentativas: " + tentativas);

            if (palpite < numeroSecreto) {
                lblResultado.setText("Seu número secreto é maior...");
            } else if (palpite > numeroSecreto) {
                lblResultado.setText("Seu número secreto é menor...");
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
            erro.setTitle("ERRO");
            erro.setHeaderText(null);
            erro.setContentText("Por favor, insira um número válido.");
            erro.showAndWait();
        }
    }

    @FXML
    private void mostrarDica() {
        tentativas += 2;
        lblTentativas.setText("Tentativas: " + tentativas);
        String paridade = (numeroSecreto % 2 == 0) ? "par" : "ímpar";
        lblResultado.setText("Dica: O número é " + paridade + ".");
    }

    @FXML
    private void reiniciarJogo() {
        Random random = new Random();
        numeroSecreto = random.nextInt(1001); // Gera número entre 0 e 1000
        tentativas = 0;
        if (lblTentativas != null) lblTentativas.setText("Tentativas: " + tentativas);
        if (lblResultado != null) lblResultado.setText("");
        if (txtPalpite != null) txtPalpite.clear();
    }
}
