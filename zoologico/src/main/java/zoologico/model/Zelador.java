package zoologico.model;

public class Zelador extends Funcionario {
    private String turno;
    
    public Zelador(int matricula, String nome, String cargo, String telefone, String email, String turno){
        super(matricula, nome, cargo, telefone, email);
        this.turno = turno;
    }
    
    // Getters e Setters
    
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
    

