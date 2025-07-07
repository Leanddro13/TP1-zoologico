package zoologico.model;

import java.util.List;
import java.util.ArrayList;

public class Habitat implements Relatorio{
    private int codigoHabitat;
    private String nome;
    private String bioma;
    private Double area;
    private List<Animal> animais;
    private Boolean statusLimpeza;
    
    public Habitat(int codigoHabitat, String nome, String bioma, Double area, Boolean statusLimpeza){
        this.codigoHabitat = codigoHabitat;
        this.nome = nome;
        this.bioma = bioma;
        this.area = area;
        this.animais = new ArrayList<>();
        this.statusLimpeza = statusLimpeza;
    }
    
    // Getters e Setters

    public int getCodigoHabitat(){
        return codigoHabitat;
    }
    
    public void setCodigoHabitat(int codigoHabitat){
        this.codigoHabitat = codigoHabitat;
    }  
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }    
    
    public String getBioma(){
        return bioma;
    }
    
    public void setBioma(String bioma){
        this.bioma = bioma;
    }
    
    public Double getArea(){
        return area;
    }
    
    public void setArea(Double area){
        this.area = area;
    }      
    
    public boolean getStatusLimpeza(){
        return statusLimpeza;
    }
    
    public void setStatusLimpeza(boolean statusLimpeza){
        this.statusLimpeza = statusLimpeza;
    }
    
    // Metodos
    
    @Override
    public String toString() {
        return this.getNome() + " (" + this.getBioma() + ")";
    }
    
    @Override
    public void descricao(){
        System.out.println(this.toString());
    }    
}
