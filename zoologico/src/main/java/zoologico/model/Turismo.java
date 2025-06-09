package zoologico.model;

import java.util.List;
import java.util.ArrayList;

public class Turismo {
    private GrupoDeVisitantes grupo;
    private List<Habitat> habitatsVisitados;
    private int duracaoEstimada;
    private GuiaTuristico guia;
    
    public Turismo(GrupoDeVisitantes grupo, int duracaoEstimada, GuiaTuristico guia){
        this.grupo = grupo;
        this.habitatsVisitados = new ArrayList<>();
        this.duracaoEstimada = duracaoEstimada;
        this.guia = guia;
    }
    
    // Getters e Setters
    
    public int getDuracaoEstimada(){
        return duracaoEstimada;
    }
    
    public void setDuracaoEstimada(int duracaoEstimada){
        this.duracaoEstimada = duracaoEstimada;
    }

     public List<Habitat> getHabitatsVisitados() {
        return habitatsVisitados;
    }

    public void setHabitatsVisitados(List<Habitat> habitatsVisitados) {
        this.habitatsVisitados = habitatsVisitados;
    }
    
    // Manipulacao da lista
    
    public void adicionarHabitat(Habitat habitat) {
        this.habitatsVisitados.add(habitat);
    }

    public void removerHabitat(Habitat habitat) {
        this.habitatsVisitados.remove(habitat);
    }
    
    // Metodos
    
    public void criarTour(){
        // Logica de criar aqui!
    }
    
    public void editarTour(){
        // Logica de editar aqui!
    }
    
    public void removerTour(){
        // Logica de remover aqui!
    }
    
    public void cronograma(){
        // Mostrar os passeios agendados aqui!
    }
    
}
