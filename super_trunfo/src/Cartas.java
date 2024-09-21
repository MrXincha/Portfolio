import java.util.Random;

  public class Cartas{
    private int forca;
    private int defesa;
    private int inteligencia;
    private int fadiga;

    public Cartas(){

      Random aleat = new Random();
      this.forca = aleat.nextInt(100);
      this.defesa = aleat.nextInt(100);
      this.inteligencia = aleat.nextInt(100);
      this.fadiga = aleat.nextInt(100);
    }

    public int getForca() {
      return forca;
    }

    public int getDefesa() {
      return defesa;
    }

    public int getInteligencia() {
      return inteligencia;
    }

    public int getFadiga() {
      return fadiga;
    }

    public String toString(){
      return "Força: " + forca +
      "\nDefesa: " + defesa +
      "\nInteligencia: " + inteligencia +
      "\nFadiga: " + fadiga;
    }
  }


