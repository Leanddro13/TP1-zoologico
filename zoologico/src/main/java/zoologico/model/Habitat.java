package zoologico.model;

import java.util.List;
import java.util.ArrayList;

public class Habitat {
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
    
    // Metodos
    
    public void adicionarHabitat(){
        // Logica de adicionar aqui!
    }
    
    public void editarHabitat(){
        // Logica de editar aqui!
    }
    
    public void removerHabitat(){
        // Logica de remover aqui!
    }
    
    public void listarHabits(){
        System.out.println("Todos os habitats: ");
        
        for (Animal a : animais){
            System.out.println(a);
        }
    }    
}
