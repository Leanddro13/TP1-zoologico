package zoologico.model;

public class Animal implements Relatorio {
    private int identificacao;
    private String nome;
    private String especie;
    private Alimento alimentacao;
    private boolean doente;
    private boolean fome;
    private Habitat habitatAtual;
    
    public Animal(int identificacao, String nome, String especie, Alimento alimentacao, boolean doente, boolean fome){
        this.identificacao = identificacao;
        this.nome = nome;
        this.especie = especie;
        this.alimentacao = alimentacao;
        this.doente = doente;
        this.fome = fome;
    }
    
    // Getters e Setters
    
    public int getIdentificacao(){
        return identificacao;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEspecie(){
        return especie;
    }
    
    public void setEspecie(String especie){
        this.especie = especie;
    }     
    
    public Alimento getAlimentacao(){
        return alimentacao;
    }
    
    public void setAlimentacao(Alimento alimentacao){
        this.alimentacao = alimentacao;
    }    
    
    public boolean getDoente(){
        return doente;
    }
    
    public void setDoente(boolean doente){
        this.doente = doente;
    }    

    public boolean getFome(){
        return fome;
    }
    
    public void setFome(boolean fome){
        this.fome = fome;
    }    
    
    public Habitat getHabitatAtual() {
        return habitatAtual;
    }

    public void setHabitatAtual(Habitat habitatAtual) {
        this.habitatAtual = habitatAtual;
    }    
    
    // Metodos
    
    @Override
    public String toString() {
        return this.getNome() + " (" + this.getEspecie() + ")";
    }
    
    @Override
    public void descricao(){
        System.out.println(this.toString());
    }
    
}
