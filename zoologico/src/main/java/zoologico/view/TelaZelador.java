package zoologico.view;

import java.util.List;
import javax.swing.JList;
import java.util.stream.Collectors;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import zoologico.control.GestorZoologico;
import zoologico.model.Animal;
import zoologico.model.Habitat;
import zoologico.model.Zelador;

public class TelaZelador extends javax.swing.JFrame {
    private GestorZoologico gestor;
    private DefaultListModel<Animal> animalListModel;

    public TelaZelador(GestorZoologico gestor) {
        this.gestor = gestor;
        initComponents();
        configurarComponentesManualmente();
        adicionarListenerDeMouseNaTabela(); 
        carregarDadosIniciais();
        setLocationRelativeTo(null);
    }
    
// Em TelaZelador.java

    private void adicionarListenerDeMouseNaTabela() {
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                // Verifica se foi um clique duplo (contagem de cliques == 2)
                if (evt.getClickCount() == 2) {
                    // Pega a linha onde o clique duplo ocorreu
                    int linhaSelecionada = jTable1.rowAtPoint(evt.getPoint());

                    if (linhaSelecionada != -1) { // Garante que o clique foi em uma linha válida
                        // Força a seleção da linha clicada (garante consistência)
                        jTable1.setRowSelectionInterval(linhaSelecionada, linhaSelecionada);

                        // Executa a ação de carregar os animais do habitat
                        carregarAnimaisDoHabitatSelecionado();
                    }
                }
            }
        });
    }
    
    private void carregarAnimaisDoHabitatSelecionado() {
        // Limpa a lista de animais atual para não misturar com a seleção anterior
        animalListModel.clear();

        int selectedRow = jTable1.getSelectedRow();

        // Verifica se alguma linha está realmente selecionada
        if (selectedRow != -1) {
            // Pega o código do habitat da primeira coluna da linha selecionada
            int codigoHabitat = (int) jTable1.getValueAt(selectedRow, 0);

            // Filtra a lista principal de animais do gestor
            List<Animal> animaisNoHabitat = gestor.getAnimais().stream()
                    .filter(animal -> animal.getHabitatAtual() != null && 
                                     animal.getHabitatAtual().getCodigoHabitat() == codigoHabitat)
                    .collect(Collectors.toList());

            // Adiciona os animais encontrados ao modelo da JList
            for (Animal animal : animaisNoHabitat) {
                animalListModel.addElement(animal);
            }
        }
        // Se nenhuma linha for selecionada (por exemplo, após limpar a seleção), a lista permanecerá vazia.
    }
    
    private void configurarComponentesManualmente() {
        // Inicializa o modelo da JList de animais
        animalListModel = new DefaultListModel<>();
        
        // Permite a seleção de múltiplos intervalos na lista de animais
        listaAnimais.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }
    
    private void carregarDadosIniciais() {
        carregarTabelaHabitats();
        carregarComboBoxZeladores();
        carregarListaAnimaisDisponiveis();
    }
    
    private void carregarTabelaHabitats() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpa a tabela

        for (Habitat h : gestor.getHabitats()) {
            model.addRow(new Object[]{
                h.getCodigoHabitat(),
                h.getNome(),
                h.getBioma(),
                h.getArea(),
                h.getStatusLimpeza() ? "Limpo" : "Sujo"
            });
        }
    }
    
    private void carregarComboBoxZeladores() {
        jComboBox1.removeAllItems(); // Limpa itens antigos
        // Filtra a lista de funcionários para pegar apenas os Zeladores
        List<Zelador> zeladores = gestor.listarTodosFuncionarios().stream()
                .filter(f -> f instanceof Zelador)
                .map(f -> (Zelador) f)
                .collect(Collectors.toList());
        
        for (Zelador z : zeladores) {
            jComboBox1.addItem(z.getNome() + " (Mat: " + z.getMatricula() + ")");
        }
    }
    
    private void carregarListaAnimaisDisponiveis() {
        animalListModel.clear(); // Limpa a lista
        // Pega apenas animais que ainda não têm um habitat
        List<Animal> animaisSemHabitat = gestor.getAnimais().stream()
                .filter(a -> a.getHabitatAtual() == null) // Assumindo que Animal tem getHabitatAtual()
                .collect(Collectors.toList());

        for (Animal a : animaisSemHabitat) {
            animalListModel.addElement(a); // Adiciona o objeto Animal à lista
        }
        listaAnimais.setModel(animalListModel);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAnimais = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Limpeza");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Zelador");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Habitat a ser limpado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nome", "Bioma", "Area", "Limpeza"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Zelador:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Animais:");

        jButton3.setText("Limpar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(listaAnimais);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(122, 122, 122)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(22, 31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um habitat de destino na tabela.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        List<Animal> animaisSelecionados = listaAnimais.getSelectedValuesList();
        if (animaisSelecionados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um ou mais animais da lista.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (jComboBox1.getSelectedIndex() == -1) {
             JOptionPane.showMessageDialog(this, "Selecione um zelador responsável.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int codigoHabitat = (int) jTable1.getValueAt(selectedRow, 0);
        Habitat habitatDestino = gestor.buscarHabitatPorCodigo(codigoHabitat);

        // Lógica para adicionar os animais ao habitat
        gestor.adicionarAnimaisAoHabitat(habitatDestino, animaisSelecionados); // Novo método no gestor
        
        JOptionPane.showMessageDialog(this, animaisSelecionados.size() + " animal(is) adicionado(s) ao habitat '" + habitatDestino.getNome() + "'.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        
        // Atualiza a lista de animais, pois os que foram adicionados não estão mais "disponíveis"
        carregarListaAnimaisDisponiveis();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um habitat na tabela para limpar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int codigoHabitat = (int) jTable1.getValueAt(selectedRow, 0);
        Habitat habitat = gestor.buscarHabitatPorCodigo(codigoHabitat); // Você precisará deste método no gestor

        if (habitat != null) {
            if (!habitat.getStatusLimpeza()) { // Se estiver sujo
                gestor.limparHabitat(codigoHabitat); // Você precisará deste método no gestor
                JOptionPane.showMessageDialog(this, "Habitat '" + habitat.getNome() + "' foi limpo!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                carregarTabelaHabitats(); // Atualiza a tabela para mostrar o novo status
            } else {
                JOptionPane.showMessageDialog(this, "Este habitat já está limpo.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JList<zoologico.model.Animal> listaAnimais;
    // End of variables declaration//GEN-END:variables
}
