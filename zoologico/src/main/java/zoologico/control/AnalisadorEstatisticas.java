package zoologico.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import zoologico.model.Animal;
import zoologico.model.Funcionario;

public class AnalisadorEstatisticas {
    private GestorZoologico gestor;
    
    public AnalisadorEstatisticas(GestorZoologico gestor){
        this.gestor = gestor;
    }
    
    // Metodos de processamento de dados
    
    public Map<String, Integer> contarAnimaisPorEspecie(){
        Map<String, Integer> contagem = new HashMap<>();
        for(Animal animal : gestor.getAnimais()){
            String especie = animal.getEspecie();
            contagem.put(especie, contagem.getOrDefault(especie, 0) + 1);
        }
        return contagem;
    }
    
    // Conta quantos funcionarios de cada cargo existem
    public Map<String, Integer> contarFuncionariosPorCargo(){
        Map<String, Integer> contagem = new HashMap<>();
        for(Funcionario func : gestor.listarTodosFuncionarios()) {
            String cargo = func.getCargo();
            contagem.put(cargo, contagem.getOrDefault(cargo, 0) + 1);
        }
        return contagem;
    }
 
    public Map<String, Integer> contarTratamentosPorVeterinario() {
        Map<String, Integer> contagem = new HashMap<>();
        // Assumindo que você tem um método no gestor para pegar o histórico
        for (zoologico.model.HistoricoTratamento tratamento : gestor.listarTodoHistoricoTratamentos()) {
            String nomeVet = tratamento.getVeterinarioResponsavel().getNome();
            contagem.put(nomeVet, contagem.getOrDefault(nomeVet, 0) + 1);
        }
    return contagem;
}
    
        // --- MÉTODOS DE GERAÇÃO DE GRÁFICOS ---

    /**
     * Usa os dados processados para criar um gráfico de BARRAS.
     * @return Um objeto JFreeChart pronto para ser exibido.
     */
    public JFreeChart criarGraficoAnimaisPorEspecie() {
        // 1. Processa os dados
        Map<String, Integer> dados = contarAnimaisPorEspecie();
        
        // 2. Prepara o dataset para o JFreeChart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : dados.entrySet()) {
            dataset.addValue(entry.getValue(), "Quantidade", entry.getKey());
        }

        // 3. Cria o objeto do gráfico
        JFreeChart graficoDeBarras = ChartFactory.createBarChart(
                "Quantidade de Animais por Espécie", // Título do Gráfico
                "Espécie",                         // Label do Eixo X
                "Quantidade",                      // Label do Eixo Y
                dataset,                           // Dados
                PlotOrientation.VERTICAL,          // Orientação
                true, true, false);                // Legenda, Tooltips, URLs

        return graficoDeBarras;
    }
    
    /**
     * Usa os dados processados para criar um gráfico de PIZZA.
     * @return Um objeto JFreeChart pronto para ser exibido.
     */
    public JFreeChart criarGraficoFuncionariosPorCargo() {
        // 1. Processa os dados
        Map<String, Integer> dados = contarFuncionariosPorCargo();

        // 2. Prepara o dataset para o gráfico de pizza
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (Map.Entry<String, Integer> entry : dados.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }

        // 3. Cria o objeto do gráfico
        JFreeChart graficoDePizza = ChartFactory.createPieChart(
                "Distribuição de Funcionários por Cargo", // Título
                dataset,                                 // Dados
                true, true, false);                      // Legenda, Tooltips, URLs

        return graficoDePizza;
    }

    /**
     * Cria um gráfico de barras mostrando o número de tratamentos por veterinário.
     * @return Um objeto JFreeChart pronto para ser exibido.
     */
    public JFreeChart criarGraficoTratamentosPorVeterinario() {
        Map<String, Integer> dados = contarTratamentosPorVeterinario();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : dados.entrySet()) {
            dataset.addValue(entry.getValue(), "Tratamentos", entry.getKey());
        }

        JFreeChart graficoDeBarras = ChartFactory.createBarChart(
                "Total de Tratamentos por Veterinário",
                "Veterinário",
                "Nº de Tratamentos",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        return graficoDeBarras;
    }    
    
}
