import java.util.ArrayList;
import java.util.List;

public class Jogador {
  private List<Cartas> cartas;
  private int pontos;

  public Jogador(){
    this.cartas = new ArrayList<>();
    this.pontos = 0;
    for (int i= 0; i < 9; i++){
      cartas.add(new Cartas());
    }
  }

  public Cartas jogarCarta() {
    if(!cartas.isEmpty()){
      return cartas.remove(0);
    }
    return null;
  }

  public int getPontos(){
    return pontos;
  }

  public void ganharPonto(){
    pontos++;
  }

  public boolean venceu(){
    return pontos >= 5;
  }
}
