public class Parede {
    private final double altura;
    private final double largura;

    public Parede(double altura, double largura){
        this.altura = altura;
        this.largura = largura;
    }

    public double calcularArea(){
        return altura * largura;
    }

    public double getAltura(){
        return altura;
    }

    public double getLargura(){
        return largura;
    }
}
