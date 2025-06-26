package zoologico.model;

import java.time.LocalDate; // Usar LocalDate para representar apenas a data

public class HistoricoTratamento {
    private Animal animalTratado;
    private Veterinario veterinarioResponsavel;
    private LocalDate dataTratamento;
    private String descricaoTratamento;

    public HistoricoTratamento(Animal animalTratado, Veterinario veterinarioResponsavel, LocalDate dataTratamento, String descricaoTratamento) {
        this.animalTratado = animalTratado;
        this.veterinarioResponsavel = veterinarioResponsavel;
        this.dataTratamento = dataTratamento;
        this.descricaoTratamento = descricaoTratamento;
    }

    // Getters
    public Animal getAnimalTratado() {
        return animalTratado;
    }

    public Veterinario getVeterinarioResponsavel() {
        return veterinarioResponsavel;
    }

    public LocalDate getDataTratamento() {
        return dataTratamento;
    }

    public String getDescricaoTratamento() {
        return descricaoTratamento;
    }

    @Override
    public String toString() {
        return "Animal: " + animalTratado.getNome() +
               ", Veterinário: " + veterinarioResponsavel.getNome() +
               ", Data: " + dataTratamento.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
               ", Descrição: " + descricaoTratamento;
    }
}