package zoologico.model;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Turismo {
    private GrupoDeVisitantes grupo;
    private List<Habitat> habitatsVisitados;
    private int duracaoEstimada;
    private GuiaTuristico guia;
    private int idTurismo;
    private LocalDate dataTurismo;
    
    public Turismo(GrupoDeVisitantes grupo, int duracaoEstimada, GuiaTuristico guia, int idTurismo, LocalDate dataTurismo){
        this.grupo = grupo;
        this.habitatsVisitados = new ArrayList<>();
        this.duracaoEstimada = duracaoEstimada;
        this.guia = guia;
        this.idTurismo = idTurismo;
        this.dataTurismo = dataTurismo;
    }
    
    // Getters e Setters
    public int getIdTurismo(){
        return idTurismo;
    }

    public List<Habitat> getHabitatsVisitados() {
        return habitatsVisitados;
    }
    
    public int getDuracaoEstimada(){
        return duracaoEstimada;
    }

    public LocalDate getDataTurismo(){
        return dataTurismo;
    }
    
    public void setDuracaoEstimada(int duracaoEstimada){
        this.duracaoEstimada = duracaoEstimada;
    }

    public void setIdTurismo(int idTurismo){
        this.idTurismo = idTurismo;
    }

    public void setHabitatsVisitados(List<Habitat> habitatsVisitados) {
        this.habitatsVisitados = habitatsVisitados;
    }

    public void setDataTurismo(LocalDate dataTurismo){
        this.dataTurismo = dataTurismo;
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
                "Guia: " + guia.getNome() +
                ",Locais: " + habitatsVisitados +
                ",Horário :" + grupo.getHorarioVisita() +
                ",Grupo: " + grupo.getQuantidadePessoas() + " Pessoas" +
                ", Data: " + dataTurismo.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                "}";
    }
    
    public void cronograma(){
        System.out.println(this.toString());
    }
    
}
