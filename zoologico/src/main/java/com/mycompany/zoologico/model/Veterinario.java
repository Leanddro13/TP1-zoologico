package com.mycompany.zoologico.model;


public class Veterinario extends Funcionario {
    private String especialidade;
    
    public Veterinario(int matricula, String nome, String cargo, String telefone, String email, String especialidade){
        super(matricula, nome, cargo, telefone, email);
        this.especialidade = especialidade;
    }
    
    
    // Getters e Setters
    
    public String getEspecialidade(){
        return especialidade;
    }
    
    public void setEspecialidade(String especialidade){
        this.especialidade = especialidade;
    }
    
    // Metodos
    
    // Recebe como parametro um animal
    public void examinarAnimal(){
        // Logica para examinar animal se tiver 
    
    }
}
