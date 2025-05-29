package com.mycompany.zoologico.model;

public abstract class Funcionario {
    private int matricula;
    private String nome;
    private String cargo;
    private String telefone;
    private String email;
    
    public Funcionario(int matricula, String nome, String cargo, String telefone, String email){
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
        this.email = email;
    }
    
    // Getters e setters

    public int getMatricula(){
        return matricula;
    }
    
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
        
    public String getCargo(){
        return cargo;
    }    
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public String getTelefone(){
        return telefone;
    }    
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getEmail(){
        return email;
    }    
    
    public void setEmail(String email){
        this.email = email;
    }    
}
