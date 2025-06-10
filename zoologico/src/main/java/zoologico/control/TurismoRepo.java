package zoologico.control;

import zoologico.model.Turismo;

import java.util.List;
import java.util.ArrayList;

public class TurismoRepo {
    private List<Turismo> turismos;

    // Construtor
    public TurismoRepo() {
        this.turismos = new ArrayList<>();
    }

    // CREATE - Adicionar um novo Turismo
    public void adicionarTurismo(Turismo turismo) {
        turismos.add(turismo);
        System.out.println("Turismo adicionado com sucesso!");
    }

    // READ - Obter todos os turismos

    public List<Turismo> listarTurismos() {
        return turismos;
    }

    // READ - Obter um turismo por íd

    //public Turismo obterTurismoId(int id) {
    //    if (indice >= 0 && indice < turismos.size()) {
    //      return turismos.get(indice);
    //  } else {
    //      System.out.println("Índice inválido!");
    //      return null;
    //  }
    //}

    public void editarTurismo(int idTurismo, int novaDuracaoEstimada){
        for(Turismo t: turismo){
            if(t.getIdTurismo() == idTurismo){
                t.setDuracaoEstimada(novaDuracaoEstimada);
                System.out.println("Tour editada com sucesso.");
                                
            }
        }
}

    // DELETE - Remover um turismo
    public void removerTurismo(int idTurismo) {
        turismos.removeIf(t -> t.getIdTurismo() == idTurismo);
            System.out.println("Turismo removido com sucesso!");
        } else {
            System.out.println("Id inválido para remoção!");
        }
    }


