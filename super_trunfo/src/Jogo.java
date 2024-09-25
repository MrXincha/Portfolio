import java.util.Scanner;

public class Jogo {
    private Jogador jogador;
    private Jogador maquina;

    public Jogo() {
        jogador = new Jogador ();
        maquina = new Jogador ();
    }

    public void iniciar(){
        Scanner scanner = new Scanner(System.in);
        while (!jogador.venceu() && !maquina.venceu()) {
            Cartas cartaJogador = jogador.jogarCarta();
            Cartas cartaMaquina = maquina.jogarCarta();

            if (cartaJogador == null || cartaMaquina == null){
                System.out.println("Fim de jogo. Sem cartas restantes.");
            }
            
            System.out.println("\nSua carta: ");
            System.out.println(cartaJogador);
            System.out.println("Escolha um atributo para competir: ");
            System.out.println("1. Força \n2. Defesa \n3. Inteligência \n4. Fadiga");

            int escolha = scanner.nextInt();
            int valorJogador = 0, valorMaquina = 0;

            switch (escolha) {
                case 1:
                    valorJogador = cartaJogador.getForca();
                    valorMaquina = cartaMaquina.getForca();
                    break;

                case 2:
                    valorJogador = cartaJogador.getDefesa();
                    valorMaquina = cartaMaquina.getDefesa();
                    break;

                case 3:
                    valorJogador = cartaJogador.getInteligencia();
                    valorMaquina = cartaMaquina.getInteligencia();
                    break;

                case 4:
                    valorJogador = cartaJogador.getFadiga();
                    valorMaquina = cartaMaquina.getFadiga();
            
                default:
                    System.out.println("Escolha inválida.");
                    continue;
            }

            System.out.println("\nCarta da máquina: ");
            System.out.println(cartaMaquina);

            if (valorJogador > valorMaquina) {
                System.out.println("Você venceu a rodada!");
                jogador.ganharPonto();
            } 
            else if (valorJogador < valorMaquina) {
                System.out.println("Você perdeu a rodada!");
                maquina.ganharPonto();
            }
            else {
                System.out.println("Empate!");
            }

            System.out.println("-------- Placar --------\nVocê: " +jogador.getPontos()+ "\nMáquina: " +maquina.getPontos());
        }

            if (jogador.venceu()){
                System.out.println("Parabéns! Você venceu o jogo!");
            }
            else {
                System.out.println("A máquina venceu o  jogo!");
            }
        }

        public static void main (String[] args) {
            Jogo jogo = new Jogo();
            jogo.iniciar();
        }
    }

