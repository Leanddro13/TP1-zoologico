package zoologico.model;

public class GrupoDeVisitantes {
    private int quantidadePessoas;
    private String horarioVisita;
    
    public GrupoDeVisitantes(int quantidadePessoas, String horarioVisita){
        this.quantidadePessoas = quantidadePessoas;
        this.horarioVisita = horarioVisita;
    }
    
    // Getters e Setters
    
    public int getQuantidadePessoas(){
        return quantidadePessoas;
    }
    
    public void setQuantidadePessoas(int quantidadePessoas){
        this.quantidadePessoas = quantidadePessoas;
    }
    
    public String getHorarioVisita(){
        return horarioVisita;
    }
    
    public void setHorarioVisita(String horarioVisita){
        this.horarioVisita = horarioVisita;
    }    
}
