package zoologico.model;

public class Animal {
    private int identificacao;
    private String nome;
    private String especie;
    private Alimento alimentacao;
    private Habitat habitat;
    private boolean doente;
    private boolean fome;
    
    
    public Animal(int identificacao, String nome, String especie, Alimento alimentacao, Habitat habitat, boolean doente, boolean fome){
        this.identificacao = identificacao;
        this.nome = nome;
        this.especie = especie;
        this.alimentacao = alimentacao;
        this.habitat = habitat;
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
                ", Habitat: " + habitat +
                ", Doente: " + (doente ? "SIM" : "NÃO") +
                ", Fome: " + (fome ? "SIM" : "NÃO") +
                '}';
    }
    
    public void descricao(){
        System.out.println(this.toString());
    }
    
}
