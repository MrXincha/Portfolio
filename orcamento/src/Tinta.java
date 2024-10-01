public class Tinta {

    private final double rendimentoTinta;
    private final double precoTinta;

    public Tinta(double rendimentoTinta, double precoTinta){
        this.rendimentoTinta = rendimentoTinta;
        this.precoTinta = precoTinta;
    }

    public int calcularQuantidadeTinta(double areaTotal) {
        return (int) Math.ceil(areaTotal / rendimentoTinta);
    }

    public double calcularCusto(int quantidadeTinta){
        return quantidadeTinta * precoTinta;
    }

    public double getRendimentoTinta() {
        return rendimentoTinta;
    }
    
    public double getPrecoTinta() {
        return precoTinta;
    }
}