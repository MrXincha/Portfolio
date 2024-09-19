import java.util.Scanner;

class ContaBancaria {
  private String titular;
  private double saldo;
  private boolean contaAtiva;

  public ContaBancaria (String titular) {
    this.titular = titular;
    this.saldo = 0.0;
    this.contaAtiva = true;
    System.out.println("Conta criada com sucesso para " + titular + "!");
  }

  public void depositar (double valor) {
    if (contaAtiva) {
      saldo += valor;
      System.out.println("Depósito de R$" + valor + " realizado com sucesso!");
    } else {
        System.out.println("Conta inativa! Não é possível concluir o depósito.");
    }
  }
  
  public void sacar (double valor) {
    if (contaAtiva) {
      if (valor <= saldo) {
        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso!");
      } else {
        System.out.println("Saldo insuficiente.");
      }
    } else {
      System.out.println("Conta inativa! Não é possível concluir o saque.");
    }
  }

  public void transferir (ContaBancaria contaDestino, double valor) {
    if (contaAtiva && contaDestino.isContaAtiva()) {
      if (valor <= saldo) {
        saldo -= valor;
        contaDestino.depositar(valor);
        System.out.println("Transferência de R$" + valor + "para " + contaDestino.getTitular() + " realizada com sucesso!");        
      } else {
        System.out.println("Saldo insuficiente para a transferência.");
      }
    } else {
      System.out.println("Conta inativa! Não é possível concluir a transferência");
    }
  }

  public void mostrarSaldo() {
    if (contaAtiva) {
      System.out.println("Saldo atual: R$" + saldo);
    }
    else {
      System.out.println("Conta inativa.");
    }
  }

  public void encerrarConta() {
    if (contaAtiva) {
      contaAtiva = false;
      System.out.println("Conta encerrada.");
    } else {
      System.out.println("Conta já está inativa.");
    }
  }

  public boolean isContaAtiva(){
    return contaAtiva;
  }

  public String getTitular() {
    return titular;
  }
}