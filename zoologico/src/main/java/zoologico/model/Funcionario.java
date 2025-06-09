package zoologico.model;

public class Funcionario {
    protected int matricula;
    protected String nome;
    protected String cargo;
    protected String telefone;
    protected String email;
    
    public Funcionario(int matricula, String nome, String cargo, String telefone, String email){
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
        this.telefone = telefone;
        this.email = email;
    }
    
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
    
    public String getEmail(){
        return email;
    }   
    
    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString() {
        return "Funcionario [Matrícula=" + matricula + ", Nome=" + nome + ", Cargo=" + cargo + "]";
    }
}