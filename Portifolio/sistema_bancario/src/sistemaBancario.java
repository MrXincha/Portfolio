import java.util.Scanner;

public class sistemaBancario {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ContaBancaria conta = null;
    boolean contaAtiva = false;

    while (true) {
      System.out.println("\n----- Menu Inicial -----");
      System.out.println("1. Criar Conta");
      System.out.println("2. Acessar Conta");
      System.out.println("0. Sair");
      System.out.print("Escolha uma opção: ");
      int opcao = scanner.nextInt();
      scanner.nextLine();

      if (opcao == 1) {
        System.out.println("Digite o nome do titular: ");
        String titular = scanner.nextLine();
        conta = new ContaBancaria(titular);
        contaAtiva = true;
      } else if (opcao == 2 && conta != null) {
        if (contaAtiva) {
          while (true) {
            System.out.println("\n----- Menu Principal -----");
            System.out.println("1. Depositar");
            System.out.println("2. Sacar");
            System.out.println("3. Transferir");
            System.out.println("4. Ver Saldo");
            System.out.println("9. Próxima Página");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcaoConta = scanner.nextInt();

            if (opcaoConta == 1) {
              System.out.println("Digite o valor a depositar: R$");
              double valor = scanner.nextDouble();
              conta.depositar(valor);              
            } 
            
            else if (opcaoConta == 2){
              System.out.println("Digite o valor a sacar: R$");
              double valor = scanner.nextDouble();
              conta.sacar(valor);
            }

            else if (opcaoConta == 3){
              System.out.println("Digite o nome do titular da conta de destino: ");
              scanner.nextLine();
              String titularDestino = scanner.nextLine();
              ContaBancaria contaDestino = new ContaBancaria(titularDestino);
              System.out.println("Digite o valor a ser transferido: R$");
              double valor = scanner.nextDouble();
              conta.transferir(contaDestino, valor);
            }

            else if (opcaoConta == 4) {
              conta.mostrarSaldo();
            }

            //Próximo menu
            else if (opcaoConta == 9) {
              while (true) {
                System.out.println("\n ----- Menu -----");
                System.out.println("1. Encerrar Conta");
                System.out.println("0. Voltar ao Menu Principal");
                System.out.print("Escolha uma opção: ");
                int opcaoFinal = scanner.nextInt();

                if (opcaoFinal == 1){
                  conta.encerrarConta();
                  contaAtiva = false;
                  break;
                }

                else if (opcaoFinal == 0){
                  break;
                }
                
                else {
                  System.out.println("Opção inválida! Tente novamente.");
                }
              }
            }

            else if (opcaoConta == 0) {
              System.out.println("Saindo...");
              System.exit(0);
            } else {
              System.out.println("Opção inválida! Tente novamente.");
            }
          }
        } else {
          System.out.println("Nenhuma conta ativa encontrada.");
        }
      } 
      
      else if (opcao == 0) {
        System.out.println("Saindo...");
        scanner.close();
        System.exit(0);
      } else {
        System.out.println("Opção inválida! Tente novamente");
      }
    }
  }
}
