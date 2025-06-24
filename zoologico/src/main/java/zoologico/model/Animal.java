package zoologico.model;

public class Animal {
    private int identificacao;
    private String nome;
    private String especie;
    private Alimento alimentacao;
    private boolean doente;
    private boolean fome;
    
    
    public Animal(int identificacao, String nome, String especie, Alimento alimentacao, boolean doente, boolean fome){
        this.identificacao = identificacao;
        this.nome = nome;
        this.especie = especie;
        this.alimentacao = alimentacao;
        this.doente = doente;
        this.fome = fome;
    }
    
    // Getters e Setters
    
    public int getIdenticacao(){
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
        
    // Metodos
    
    @Override
    public String toString(){
        return "Animal {" +
                "ID: " + identificacao +
                ", Nome: " + nome +
                ", Especie: " + especie +
                ", Alimentacao: " + alimentacao +
                ", Doente: " + (doente ? "SIM" : "NÃO") +
                ", Fome: " + (fome ? "SIM" : "NÃO") +
                '}';
    }
    
    public void descricao(){
        System.out.println(this.toString());
    }
    
}
