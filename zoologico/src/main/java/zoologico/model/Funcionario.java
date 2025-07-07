package zoologico.model;

public abstract class Funcionario {
    protected int matricula;
    protected String nome;
    protected String cargo;
    protected String telefone;
    
    public Funcionario(int matricula, String nome, String cargo, String telefone){
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
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

    // Metodos
    
    @Override
    public String toString() {
        return "Funcionario [Matrícula=" + matricula + ", Nome=" + nome + ", Cargo=" + cargo + "]";
    }
}