package zoologico.model;

import zoologico.model.Alimento;

public class Animal {
    private int identificacao;
    private String nome;
    private String especie;
    private int idade;
    private Alimento alimentacao;
    private Habitat habitat;
    
    
    public Animal(int identificacao, String nome, String especie, int idade, Alimento alimentacao, Habitat habitat){
        this.identificacao = identificacao;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.alimentacao = alimentacao;
        this.habitat = habitat;
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
        
    // Metodos
    
    public void descricao(){
        // Logica para descrever os animais
    }
}
