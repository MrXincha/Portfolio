import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Robo robo = new Robo();
        Calculadora roboCalc = new Calculadora();

        System.out.println("Nome do robo: " + robo.getNome());     
        System.out.println("Data de Fabricação: " + robo.getData_fab());
        System.out.println("Bateria é: " + robo.getBateria() + "%");
                
        int opcao;
        do {
            System.out.println("\n---- Menu de Seleção ----\n");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Recarregar");
            System.out.println("0. Sair");
            System.out.print("Escolha uma operação: ");
            
            opcao = scanner.nextInt();

            if(opcao >= 1 && opcao <= 4) {
                if (robo.getBateria() > 0) {
                    System.out.print("Digite o primeiro número: ");
                    float numero1 = scanner.nextFloat();
                    System.out.print("Digite o segundo número: ");
                    float numero2 = scanner.nextFloat();
                
                    switch (opcao) {
                        case 1:
                            System.out.println("Resultado da Soma: " + roboCalc.Soma(numero1, numero2));
                            break;
                        case 2:
                            System.out.println("Resultado da Subtração: " + roboCalc.Subtracao(numero1, numero2));
                            break;
                        case 3:
                            System.out.println("Resultado da Multiplicação: " + roboCalc.Multiplicacao(numero1, numero2));
                            break;
                        case 4:
                            if (numero2 != 0) {
                                System.out.println("Resultado da Divisão: " + roboCalc.Divisao(numero1, numero2));
                            } else {
                                System.out.println("Erro: Divisão por zero!");
                            }
                            break;
                    }
                    robo.descarregarBateria();
                    System.out.println("Bateria atual: " + robo.getBateria() + "%");
                } else {
                    System.out.println("\nBateria fraca! Recarregue o robô.");
                }
            } else if (opcao == 5) {
                robo.recarregarBateria();
                System.out.println("Bateria recarregada para 100%.");
            } else if (opcao != 0) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        System.out.println("Saindo...");
        scanner.close();
    }
}