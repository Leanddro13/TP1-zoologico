package zoologico.model;

// import com.mycompany.zoologico.model.Funcionario;
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
    
    public void adicionarFuncionario(){
        // Logica para adicionar funcionario
    }
    
    public void editarFuncionario(){
        // Logica para editrar funcionario
    }

    public void removerFuncionario(){
        // Logica para remover funcionario
    }

    
    public void listarFuncionarios(){
        System.out.println("Todos os funcionarios: ");
        
        for (Funcionario f : listaFuncionarios){
            System.out.println(f);
        }
    }
    
    
}
