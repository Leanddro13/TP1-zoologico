package zoologico.control;

import zoologico.model.Animal;
import zoologico.model.Habitat;

import java.util.ArrayList;
import java.util.List;


public class GestorZoologico {
    private List<Animal> animais;
    private List<Habitat> habitats;
    
    public GestorZoologico(){
        this.animais = new ArrayList<>();
        this.habitats = new ArrayList<>();
    }
    
    
    // Getters
    
    public List<Animal> getAnimais() {
        return animais;
    }

    public List<Habitat> getHabitats() {
        return habitats;
    }        
    
    
    // Métodos para Habitat
    
    
    public void adicionarHabitat(Habitat habitat){
        habitats.add(habitat);
        System.out.println("Habitat adicionado com sucesso.");
    }
    
    public void editarHabitat(int codigo, String novoNome, String novoBioma, Double novaArea, Boolean novoStatusLimpeza){
        for(Habitat h: habitats){
            if(h.getCodigoHabitat() == codigo){
                h.setNome(novoNome);
                h.setBioma(novoBioma);
                h.setArea(novaArea);
                h.setStatusLimpeza(novoStatusLimpeza);
                System.out.println("Habitat editado com sucesso.");
                return;                
            }
        }
        System.out.println("Habitat com código " + codigo + " não encontrado.");
    }
    
    public void removerHabitat(int codigo){
        habitats.removeIf(h -> h.getCodigoHabitat() == codigo);
        System.out.println("Habitat removido!!"); // Se existir        
    }
    
    
    public void listarHabitats() {
        for (Habitat h : habitats) {
            System.out.println("Habitat: " + h.getNome() + ", Código: " + h.getCodigoHabitat());
        }
    }
    
    
    // Métodos para Animal

    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
        // animal.getHabitat().getAnimais().add(animal); // Implementar essa lógica para proxima entrega
        System.out.println("Animal adicionado com sucesso.");
    }

    public void editarAnimal(int id, String novoNome, String novaEspecie, boolean novoStatusDoente, boolean novoStatusFome) {
        for (Animal a : animais) {
            if (a.getIdenticacao() == id) {
                a.setNome(novoNome);
                a.setEspecie(novaEspecie);
                a.setDoente(novoStatusDoente);
                a.setFome(novoStatusFome);
                System.out.println("Animal editado com sucesso.");
                return;
            }
        }
        System.out.println("Animal com ID " + id + " não encontrado.");
    }

    public void removerAnimal(int id) {
        animais.removeIf(a -> a.getIdenticacao() == id);
        System.out.println("Animal removido!!"); // Se existir
    }

    public void listarAnimais() {
        for (Animal a : animais) {
            a.descricao();
        }
    }


}
