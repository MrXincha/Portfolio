import java.awt.*;
import javax.swing.*;

public class MainGUI {
    private Robo robo;
    private Calculadora calculadora;
    
    private JFrame frame;
    private JLabel lblBateria;
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JTextArea txtResultado;
    
    public MainGUI() {
        robo = new Robo();
        calculadora = new Calculadora();
        
        frame = new JFrame("Robo Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2));

        // Componentes da interface
        lblBateria = new JLabel("Bateria: " + robo.getBateria() + "%");
        txtNumero1 = new JTextField();
        txtNumero2 = new JTextField();
        txtResultado = new JTextArea();
        txtResultado.setEditable(false);

        JButton btnSoma = new JButton("Soma");
        JButton btnSubtracao = new JButton("Subtração");
        JButton btnMultiplicacao = new JButton("Multiplicação");
        JButton btnDivisao = new JButton("Divisão");
        JButton btnRecarregar = new JButton("Recarregar Bateria");

        // Adicionando componentes ao frame
        frame.add(new JLabel("Primeiro Número:"));
        frame.add(txtNumero1);
        frame.add(new JLabel("Segundo Número:"));
        frame.add(txtNumero2);
        frame.add(lblBateria);
        frame.add(new JLabel(""));
        frame.add(btnSoma);
        frame.add(btnSubtracao);
        frame.add(btnMultiplicacao);
        frame.add(btnDivisao);
        frame.add(btnRecarregar);
        frame.add(new JScrollPane(txtResultado));

        // Ações dos botões
        btnSoma.addActionListener(e -> realizarOperacao("Soma"));
        btnSubtracao.addActionListener(e -> realizarOperacao("Subtracao"));
        btnMultiplicacao.addActionListener(e -> realizarOperacao("Multiplicacao"));
        btnDivisao.addActionListener(e -> realizarOperacao("Divisao"));
        btnRecarregar.addActionListener(e -> recarregarBateria());

        frame.setVisible(true);
    }
    
    private void realizarOperacao(String operacao) {
        try {
            float numero1 = Float.parseFloat(txtNumero1.getText());
            float numero2 = Float.parseFloat(txtNumero2.getText());
            float resultado = 0;

            switch (operacao) {
                case "Soma":
                    resultado = calculadora.Soma(numero1, numero2);
                    break;
                case "Subtracao":
                    resultado = calculadora.Subtracao(numero1, numero2);
                    break;
                case "Multiplicacao":
                    resultado = calculadora.Multiplicacao(numero1, numero2);
                    break;
                case "Divisao":
                    if (numero2 != 0) {
                        resultado = calculadora.Divisao(numero1, numero2);
                    } else {
                        txtResultado.setText("Erro: Divisão por zero!");
                        return;
                    }
                    break;
            }
            
            robo.descarregarBateria();
            lblBateria.setText("Bateria: " + robo.getBateria() + "%");
            txtResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            txtResultado.setText("Por favor, insira números válidos.");
        }
    }
    
    private void recarregarBateria() {
        robo.recarregarBateria();
        lblBateria.setText("Bateria: " + robo.getBateria() + "%");
        txtResultado.setText("Bateria recarregada para 100%.");
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
