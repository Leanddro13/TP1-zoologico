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
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public void adicionarFuncionario(Funcionario funcionario){
        this.listaFuncionarios.add(funcionario);
    }
    
    public boolean editarFuncionario(int matricula, String novoNome, String novoCargo, String novoTelefone, String novoEmail){
        for (Funcionario f : listaFuncionarios) {
            if (f.getMatricula() == matricula) {
                f.setNome(novoNome);
                f.setCargo(novoCargo);
                f.setTelefone(novoTelefone);
                f.setEmail(novoEmail);
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