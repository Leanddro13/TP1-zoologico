package zoologico.model;

public class Zelador extends Funcionario {
    private String turno;
    
    public Zelador(int matricula, String nome, String cargo, String telefone, String turno){
        super(matricula, nome, cargo, telefone);
        this.turno = turno;
    }
    
    // Getters e Setters
   
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    // Metodos
    // Altera o status de limpeza do habitat
    public void limparHabitat(Habitat habitat){
        if(habitat != null){
            habitat.setStatusLimpeza(true);
            System.out.println("O zelador " + getNome() + " limpou o habitat " + habitat.getNome());
        }
        else{
            System.out.println("Habitat inválido para limpeza");
        }
    }
    
    // Alterar o status de fome do animal (Nao usado)
    public void alimentarAnimal(Animal animal){
        if(animal != null && animal.getFome()){
            animal.setFome(false);
            System.out.println("O zelador " + getNome() + " alimentou o animal: " + animal.getNome());
        }
        else if(animal != null && !animal.getFome()){
            System.out.println("O animal " + animal.getNome() + " já está alimentado.");
        }
        else{
            System.out.println("Animal inválido para alimentação.");
        }
    }
    
    @Override
    // Sobrescrita do metodo da classe funcionario
    public String toString(){
        return "Zelador{" +
                "Nome" + nome +
                "Matricula" + matricula +
                "Telefone" + telefone +
                "}";
    }
}
    

