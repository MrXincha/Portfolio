public class Calculadora {
    private final Robo Robo = new Robo();

    public Robo getRobo() {
        return Robo;
    }

    public float Soma(float numero1, float numero2) {
        return numero1 + numero2;
    }

    public float Subtracao(float numero1, float numero2) {
        return numero1 - numero2;
    }

    public float Divisao(float numero1, float numero2) {
        return numero1 / numero2;
    }

    public float Multiplicacao(float numero1, float numero2) {
        return numero1 * numero2;
    }
}