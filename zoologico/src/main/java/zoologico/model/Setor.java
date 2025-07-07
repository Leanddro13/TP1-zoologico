package zoologico.model;

import java.util.List;
import java.util.ArrayList;

public class Setor {
    private String descricao;
    private List<Funcionario> listaFuncionarios;
    
    public Setor(String descricao){
        this.descricao = descricao;
        this.listaFuncionarios = new ArrayList<>();
    }
    
    // Getters e Setters
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    // Metodos
    
    public void adicionarFuncionario(Funcionario funcionario){
        this.listaFuncionarios.add(funcionario);
    }
    
    public boolean editarFuncionario(int matricula, String novoNome, String novoCargo, String novoTelefone, String novoEmail){
        for (Funcionario f : listaFuncionarios) {
            if (f.getMatricula() == matricula) {
                f.setNome(novoNome);
                f.setCargo(novoCargo);
                f.setTelefone(novoTelefone);
                return true;
            }
        }
        return false;
    }

    public boolean removerFuncionario(int matricula){
        return this.listaFuncionarios.removeIf(f -> f.getMatricula() == matricula);
    }
    
    public List<Funcionario> getListaFuncionarios(){
        return new ArrayList<>(this.listaFuncionarios);
    }
}