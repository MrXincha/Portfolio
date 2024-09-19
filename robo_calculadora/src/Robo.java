public class Robo{

    private String data_fab;
    private String nome;
    private int bateria;

    public Robo(){
        this.data_fab = "27/08/2024";
        this.nome = "R2D2";
        this.bateria = 100;
    }

    public Robo(String data_fab, String nome, int bateria){
        this.data_fab = data_fab;
        this.nome = nome;
        this.bateria = bateria;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setData_fab(String data_fab) {
        this.data_fab = data_fab;
    }

    public String getData_fab() {
        return this.data_fab;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public int getBateria() {
        return this.bateria;
    }

    public void descarregarBateria (){
        if (this.bateria > 0) {
            this.bateria -= 1;
        }
    }

    public void recarregarBateria(){
        this.bateria = 100;
    }
}