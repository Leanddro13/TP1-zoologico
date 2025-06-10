package zoologico.model;

import java.util.List;
import java.util.ArrayList;

public class Turismo {
    private GrupoDeVisitantes grupo;
    private List<Habitat> habitatsVisitados;
    private int duracaoEstimada;
    private GuiaTuristico guia;
    private int idTurismo;
    
    public Turismo(GrupoDeVisitantes grupo, int duracaoEstimada, GuiaTuristico guia, int idTurismo){
        this.grupo = grupo;
        this.habitatsVisitados = new ArrayList<>();
        this.duracaoEstimada = duracaoEstimada;
        this.guia = guia;
        this.idTurismo = idTurismo;
    }
    
    // Getters e Setters
    public int getIdTurismo(){
        return idTurismo;
    }
    
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
    @Override
    public String toString(){
        return "Tour {" +
                "Guia:" + guia.getNome() +
                ",Locais:" + habitatsVisitados +
                ",Horário:" + grupo.getHorarioVisita() +
                ",Grupo:" + grupo.getQuantidadePessoas() + "Pessoas" +
                "}";
    }
    
    public void cronograma(){
        System.out.println(this.toString());
    }
    
}
