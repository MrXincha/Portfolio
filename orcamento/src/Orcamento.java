import java.util.ArrayList;
import java.util.Scanner;

public class Orcamento {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Parede> paredes = new ArrayList<>();

            System.out.println("Informe o rendimento da tinta (Quantos m² uma lata cobre): ");
            double rendimentoTinta = scanner.nextDouble();

            System.out.println("Informe o preço da tinta: R$");
            double precoTinta = scanner.nextDouble();

            Tinta tinta = new Tinta(rendimentoTinta, precoTinta);

            // Inicializando a variável para armazenar a área total
            double areaTotal = 0;

            // Escolher o tipo de cálculo
            int opcao;
            do {
                System.out.println("Escolha o método de cálculo:");
                System.out.println("1- Inserir área total");
                System.out.println("2- Inserir cômodos");
                System.out.println("3- Inserir Paredes");
                opcao = scanner.nextInt();
            } while (opcao < 1 || opcao > 3);

            switch (opcao) {
                case 1:
                    // Inserir área total
                    do {
                        System.out.println("Insira a área total a ser pintada: ");
                        areaTotal = scanner.nextDouble();
                        if (areaTotal <= 0) {
                            System.out.println("A área deve ser maior que zero.");
                        }
                    } while (areaTotal <= 0);
                    break;

                case 2:
                    // Inserir cômodos
                    System.out.println("Quantos cômodos você deseja adicionar?");
                    int numComodos = scanner.nextInt();

                    for (int i = 0; i < numComodos; i++) {
                        System.out.println("Inserindo paredes para o cômodo " + (i + 1));
                        System.out.println("Quantas paredes tem este cômodo?");
                        int numParedes = scanner.nextInt();

                        for (int j = 0; j < numParedes; j++) {
                            areaTotal += inserirParede(scanner, j);
                        }
                    }
                    break;

                case 3:
                    // Inserir múltiplas paredes manualmente
                    boolean adicionarParedes = true;
                    while (adicionarParedes) {
                        areaTotal += inserirParede(scanner, 0);
                        System.out.println("Deseja adicionar mais uma parede? (s/n)");
                        String resposta = scanner.next();
                        adicionarParedes = resposta.equalsIgnoreCase("s");
                    }
                    break;

                default:
                    throw new AssertionError();
            }

            // Calculo final
            int quantidadeTinta = tinta.calcularQuantidadeTinta(areaTotal);
            double calcularCusto = tinta.calcularCusto(quantidadeTinta);

            System.out.println("Resumo do Cálculo: ");
            System.out.println("Área total a ser pintada: " + areaTotal + " m²");
            System.out.println("Quantidade de latas de tinta necessárias: " + quantidadeTinta + " latas");
            System.out.printf("Custo total da tinta: R$ %.2f\n", calcularCusto);
            System.out.println("\nOs valores são apenas uma simulação e podem não refletir a quantidade total necessária.");
        }
    }

    // Método para inserir paredes válidas
    private static double inserirParede(Scanner scanner, int index) {
        double altura, largura;

        do {
            System.out.println("Informe a altura da parede " + (index + 1) + " (em metros): ");
            altura = scanner.nextDouble();
            if (altura <= 0) {
                System.out.println("A altura deve ser maior que zero.");
            }
        } while (altura <= 0);

        do {
            System.out.println("Informe a largura da parede " + (index + 1) + " (em metros): ");
            largura = scanner.nextDouble();
            if (largura <= 0) {
                System.out.println("A largura deve ser maior que zero.");
            }
        } while (largura <= 0);

        Parede parede = new Parede(altura, largura);
        return parede.calcularArea();
    }
}