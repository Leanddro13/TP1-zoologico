package zoologico.view;

import java.awt.GridLayout;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import zoologico.control.AnalisadorEstatisticas;
import zoologico.control.GestorZoologico;

public class TelaAnalise extends JFrame {

    private GestorZoologico gestor;

    public TelaAnalise(GestorZoologico gestor) {
        this.gestor = gestor;
        
        setTitle("Dashboard de Análise do Zoológico");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Define um layout para organizar os gráficos (ex: 2 colunas)
        setLayout(new GridLayout(2, 2)); 
        
        iniciarComponentes();
        
        setSize(1200, 600); // Define um tamanho para a janela
        setLocationRelativeTo(null); // Centraliza
    }

    private void iniciarComponentes() {
        // 1. Cria o analisador passando o gestor
        AnalisadorEstatisticas analisador = new AnalisadorEstatisticas(gestor);
        
        // 2. Pede ao analisador para criar os gráficos
        JFreeChart graficoAnimais = analisador.criarGraficoAnimaisPorEspecie();
        JFreeChart graficoFuncionarios = analisador.criarGraficoFuncionariosPorCargo();
        
        // 3. Cria painéis Swing para exibir os gráficos
        ChartPanel painelGraficoAnimais = new ChartPanel(graficoAnimais);
        ChartPanel painelGraficoFuncionarios = new ChartPanel(graficoFuncionarios);
        
        JFreeChart graficoVeterinarios = analisador.criarGraficoTratamentosPorVeterinario();
        
        // 4. Adiciona os painéis à janela
        add(painelGraficoAnimais);
        add(painelGraficoFuncionarios);
        add(new ChartPanel(graficoVeterinarios));

    }
}