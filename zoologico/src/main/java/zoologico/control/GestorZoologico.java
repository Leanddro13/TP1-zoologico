package zoologico.control;

import zoologico.model.Animal;
import zoologico.model.Habitat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

import zoologico.model.Funcionario;
import zoologico.model.Zelador;
import zoologico.model.Veterinario;
import zoologico.model.GuiaTuristico;
import zoologico.model.HistoricoTratamento;

public class GestorZoologico {
    private List<Animal> animais;
    private List<Habitat> habitats;
    private List<Funcionario> listaFuncionarios;
    private List<HistoricoTratamento> listaHistoricoTratamentos;
    
    public GestorZoologico(){
        this.animais = new ArrayList<>();
        this.habitats = new ArrayList<>();
        this.listaFuncionarios = new ArrayList<>();
        this.listaHistoricoTratamentos = new ArrayList<>();
        
        inicializarDadosPreDefinidos();
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

    public boolean adicionarAnimal(Animal novoAnimal) {
        for(Animal animalExistente : animais){
            if(animalExistente.getIdentificacao() == novoAnimal.getIdentificacao()){
                System.out.println("Erro: já existe um animal cadastrado com o ID " + novoAnimal.getIdentificacao());
                return false;
            }
        }
        
        animais.add(novoAnimal);
        System.out.println("Animal adicionado com sucesso!");
        return true;
    }

    public boolean editarAnimal(int id, String novoNome, String novaEspecie, boolean novoStatusDoente, boolean novoStatusFome) {
        for (Animal a : animais) {
            if (a.getIdentificacao() == id) {
                a.setNome(novoNome);
                a.setEspecie(novaEspecie);
                a.setDoente(novoStatusDoente);
                a.setFome(novoStatusFome);
                System.out.println("Animal editado com sucesso.");
                return true;
            }
        }
        return false;
    }

    public boolean removerAnimal(int id) {
        return animais.removeIf(a -> a.getIdentificacao() == id);
    }

    public void listarAnimais() {
        for (Animal a : animais) {
            a.descricao();
        }
    }
    
    public List<Animal> listarAnimaisDoentes() {
        return animais.stream()
                .filter(Animal::getDoente) // <<<< CORREÇÃO AQUI! Use isDoente
                .collect(Collectors.toList());
    }
    
    public Animal buscarAnimalPorId(int id) {
        for (Animal animal : animais) {
            if (animal.getIdentificacao() == id) {
                return animal;
            }
        }
        return null;
    }
    
    public Animal buscarAnimalPorNome(String nome) {
        for (Animal animal : animais) {
            if (animal.getNome() != null && animal.getNome().equalsIgnoreCase(nome)) {
                return animal;
            }
        }
        return null;
    }
    
    public boolean curarAnimal(int idAnimal, Veterinario veterinario, String dataTratamentoStr, String descricaoTratamento) {
        Animal animal = buscarAnimalPorId(idAnimal);
        if (animal != null && animal.getDoente()) {
            animal.setDoente(false); // Marca como não doente
            System.out.println("Animal " + animal.getNome() + " (ID: " + animal.getIdentificacao() + ") foi curado por " + veterinario.getNome() + " em " + dataTratamentoStr + " com o tratamento: " + descricaoTratamento);
            
            // Adicionar histórico de tratamento
            try {
                // Converte a string da data para LocalDate
                LocalDate dataTratamento = LocalDate.parse(dataTratamentoStr, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                HistoricoTratamento historico = new HistoricoTratamento(animal, veterinario, dataTratamento, descricaoTratamento);
                adicionarHistoricoTratamento(historico); // Adiciona ao histórico geral
            } catch (java.time.format.DateTimeParseException e) {
                System.err.println("Erro ao converter data do tratamento: " + dataTratamentoStr + " - " + e.getMessage());
                // Poderia lançar uma exceção ou lidar com o erro de outra forma
            }
            return true;
        }
        return false;
    }
   
    
    private boolean existeFuncionario(int matricula) {
        return listaFuncionarios.stream().anyMatch(f -> f.getMatricula() == matricula);
    }
    
    public void adicionarFuncionario(Funcionario funcionario) {
        if (funcionario != null) {
            // Verifica se a matrícula já existe para evitar duplicatas
            if (!existeFuncionario(funcionario.getMatricula())) {
                this.listaFuncionarios.add(funcionario);
                System.out.println("Funcionario " + funcionario.getNome() + " (Matrícula: " + funcionario.getMatricula() + ") adicionado.");
            } else {
                System.out.println("Erro: Funcionario com matrícula " + funcionario.getMatricula() + " já existe. Não foi adicionado.");
            }
        } else {
            System.out.println("Erro: Tentativa de adicionar funcionário nulo.");
        }
    }
    
    private void inicializarDadosPreDefinidos(){
        Zelador zelador1 = new Zelador(100, "Carlos Silva", "Zelador Chefe", "98765-4321", "Manhã");
        Zelador zelador2 = new Zelador(101, "Bruno Duarte", "Zelador tecnico", "12345-6789", "Tarde");
        Zelador zelador3 = new Zelador(102, "Dibio Smith", "Zelador tecnico", "45232-3289", "Noite");
        
        Veterinario veterinario1 = new Veterinario(200, "Ana Pereira", "Veterinario Geral", "42096-6781", "Manhã");
        Veterinario veterinario2 = new Veterinario(201, "Joao Carlos", "Veterinario tecnico", "12213-5642", "Tarde");
        Veterinario veterinario3 = new Veterinario(202, "Zenilda Santos", "Veterinario tecnico", "98145-3201", "Noite");

        GuiaTuristico guia1 = new GuiaTuristico(300, "Salomao Salarim", "Guia Turístico Senior", "55555-1111", "Português");
        GuiaTuristico guia2 = new GuiaTuristico(301, "Roberto Galvao", "Guia Turístico Junior", "44444-2222", "Inglês");
        GuiaTuristico guia3 = new GuiaTuristico(302, "Maria Socorro", "Guia Turístico Junior", "33333-2222", "Frances");

    this.adicionarFuncionario(zelador1);
    this.adicionarFuncionario(zelador2);
    this.adicionarFuncionario(zelador3);
    this.adicionarFuncionario(veterinario1);
    this.adicionarFuncionario(veterinario2);
    this.adicionarFuncionario(veterinario3);
    this.adicionarFuncionario(guia1);
    this.adicionarFuncionario(guia2);
    this.adicionarFuncionario(guia3);
    }
    
    public List<Funcionario> listarTodosFuncionarios() {
        return new ArrayList<>(this.listaFuncionarios); 
    }
    
    
    public void adicionarHistoricoTratamento(HistoricoTratamento historico) {
        if (historico != null) {
            this.listaHistoricoTratamentos.add(historico);
            System.out.println("Histórico de tratamento adicionado para o animal: " + historico.getAnimalTratado().getNome());
        }
    }

    // NOVO: Método para listar todo o histórico de tratamento
    public List<HistoricoTratamento> listarTodoHistoricoTratamentos() {
        return new ArrayList<>(this.listaHistoricoTratamentos);
    }
}
