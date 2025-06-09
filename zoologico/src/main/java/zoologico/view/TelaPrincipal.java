package zoologico.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import zoologico.model.Funcionario;
import zoologico.model.Setor;

public class TelaPrincipal extends JFrame {

    private final Setor setor;
    private JTable tabelaFuncionarios;
    private DefaultTableModel modeloTabela;
    private TableRowSorter<DefaultTableModel> sorter;

    public TelaPrincipal() {
        this.setor = new Setor("Funcionários do Zoológico");
        initComponents();
        atualizarTabela();
    }

    private void initComponents() {
        setTitle("Painel de Funcionários");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(5, 5));

        JPanel painelEsquerdo = new JPanel();
        painelEsquerdo.setPreferredSize(new Dimension(150, 0));
        painelEsquerdo.setLayout(new GridLayout(5, 1, 10, 10));
        painelEsquerdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton btnCriar = new JButton("Criar");
        btnCriar.addActionListener(e -> abrirTelaCadastro());
        
        painelEsquerdo.add(btnCriar);
        add(painelEsquerdo, BorderLayout.WEST);

        JPanel painelDireito = new JPanel(new BorderLayout(10, 10));
        painelDireito.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel painelPesquisa = new JPanel(new BorderLayout(5, 5));
        JLabel lblIconePesquisa = new JLabel("🔍");
        JTextField txtPesquisar = new JTextField();
        painelPesquisa.add(lblIconePesquisa, BorderLayout.WEST);
        painelPesquisa.add(txtPesquisar, BorderLayout.CENTER);
        
        painelDireito.add(painelPesquisa, BorderLayout.NORTH);
        
        modeloTabela = new DefaultTableModel(new Object[]{"Matrícula", "Nome", "Cargo", "Telefone", "Email"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaFuncionarios = new JTable(modeloTabela);
        
        sorter = new TableRowSorter<>(modeloTabela);
        tabelaFuncionarios.setRowSorter(sorter);

        painelDireito.add(new JScrollPane(tabelaFuncionarios), BorderLayout.CENTER);
        add(painelDireito, BorderLayout.CENTER);
        
        tabelaFuncionarios.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    abrirTelaEdicao();
                }
            }
        });
        
        txtPesquisar.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { filtrarTabela(); }
            public void removeUpdate(DocumentEvent e) { filtrarTabela(); }
            public void changedUpdate(DocumentEvent e) { filtrarTabela(); }
            
            public void filtrarTabela() {
                String texto = txtPesquisar.getText();
                if (texto.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
                }
            }
        });
    }

    public void atualizarTabela() {
        modeloTabela.setRowCount(0);
        List<Funcionario> funcionarios = setor.getListaFuncionarios();
        for (Funcionario f : funcionarios) {
            modeloTabela.addRow(new Object[]{f.getMatricula(), f.getNome(), f.getCargo(), f.getTelefone(), f.getEmail()});
        }
    }

    private void abrirTelaCadastro() {
        new TelaCriarFuncionario(this, setor).setVisible(true);
    }

    private void abrirTelaEdicao() {
        int selectedRow = tabelaFuncionarios.getSelectedRow();
        if(selectedRow == -1) return;
        
        int modelRow = tabelaFuncionarios.convertRowIndexToModel(selectedRow);
        int matricula = (int) modeloTabela.getValueAt(modelRow, 0);
        
        Funcionario funcParaEditar = setor.getListaFuncionarios().stream()
                .filter(f -> f.getMatricula() == matricula).findFirst().orElse(null);
        
        if (funcParaEditar != null) {
            new TelaEditarFuncionario(this, setor, funcParaEditar).setVisible(true);
        }
    }
}