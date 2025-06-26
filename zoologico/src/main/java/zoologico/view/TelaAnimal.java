package zoologico.view;

import javax.swing.table.DefaultTableModel; // Importe esta classe
import javax.swing.DefaultComboBoxModel;
import javax.swing.ButtonGroup;
import zoologico.control.GestorZoologico; // Importe o gestor
import zoologico.model.Animal; // Importe o modelo
import zoologico.model.Alimento;
import javax.swing.JOptionPane; // Importe para mostrar pop-ups

public class TelaAnimal extends javax.swing.JFrame {
    private GestorZoologico gestor;
    private ButtonGroup grupoStatusDoente;
    private ButtonGroup grupoStatusFome;
    
    public TelaAnimal(GestorZoologico gestor) {
        this.gestor = gestor;
        initComponents();
        configurarComponentesIniciais();
        configurarGruposDeBotoes();
        // configurarComponentesIniciais();
    }
    
    public TelaAnimal() {
        initComponents();
        // configurarComponentesIniciais();
    }
    
private void configurarGruposDeBotoes() {
    grupoStatusDoente = new ButtonGroup();
    grupoStatusDoente.add(jRadioButton1); // "Doente"
    grupoStatusDoente.add(jRadioButton2); // Assumindo que este seja o botão "Saudável"

    grupoStatusFome = new ButtonGroup();
    grupoStatusFome.add(jRadioButton3); // "Sim"
    grupoStatusFome.add(jRadioButton4); // Assumindo que este seja o botão "Não"
}    
    
    private void configurarComponentesIniciais(){
        popularComboBoxAlimentos(); // Chame o novo método aqui
        atualizarTabela();
    }    
    
    private void atualizarTabela() {
        String[] colunas = {"ID", "Nome", "Espécie", "Alimento", "Doente", "Fome"};

        // Cria um DefaultTableModel e sobrescreve o isCellEditable "na hora"
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], colunas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Isso faz com que nenhuma célula seja editável
                return false;
            }
        };

        // O resto do código é exatamente o mesmo...
            for (Animal animal : gestor.getAnimais()) {
            model.addRow(new Object[]{
                animal.getIdentificacao(),
                animal.getNome(),
                animal.getEspecie(),
                animal.getAlimentacao(),
                animal.getDoente() ? "Doente" : "Saudavel",
                animal.getFome() ? "Sim" : "Nao"
            });
        }

        jTable1.setModel(model);

    }
    

    
    private void popularComboBoxAlimentos() {
        jComboBox1.removeAllItems();

        DefaultComboBoxModel<Alimento> model = new DefaultComboBoxModel<>();
        
        // Adiciona cada valor do enum ao modelo
        for (Alimento alimento : Alimento.values()) {
            model.addElement(alimento);
        }

        // Define o modelo na sua JComboBox
        jComboBox1.setModel(model);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        pesquisarId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Animais");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Animais");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Animais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15))); // NOI18N
        jPanel1.setToolTipText("Cadastro");
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 100));

        jLabel2.setText("Aliementação:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome:");

        jLabel4.setText("Espécie:");

        jLabel6.setText("Identificão:");

        jLabel7.setText("Saúde:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>());
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Doente");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Saudável");
        jRadioButton2.setToolTipText("");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Esta com fome?");

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Sim");
        jRadioButton3.setToolTipText("");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Não");
        jRadioButton4.setToolTipText("");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton1)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pesquisarId.setText("Pesquisar animal por ID");
        pesquisarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarIdActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Animais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Liberation Sans", 1, 15))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Identificação", "Nome", "Especie", "Alimentação", "Saude", "Fome"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Criar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Excluir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Examinar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Pesquisar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(325, 325, 325))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton5))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pesquisarId, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Metodo para limpar os campos
    private void limparCampos() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        // Se você usa ButtonGroup (recomendado)
        if (grupoStatusDoente != null) {
            grupoStatusDoente.clearSelection();
        }
        if (grupoStatusFome != null) {
            grupoStatusFome.clearSelection();
        }
    }
   
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void pesquisarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pesquisarIdActionPerformed

    // Botão para remover
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // 1. Identificar o animal a ser removido
        int linhaSelecionada = jTable1.getSelectedRow();

        // Verifica se alguma linha foi realmente selecionada
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecione um animal na tabela para remover.", "Nenhum animal selecionado", JOptionPane.WARNING_MESSAGE);
            return; // Para a execução do método aqui
        }

        try {
            // Pega o ID da coluna 0 da linha selecionada
            int idParaRemover = Integer.parseInt(jTable1.getValueAt(linhaSelecionada, 0).toString());
            String nomeAnimal = jTable1.getValueAt(linhaSelecionada, 1).toString(); // Pega o nome para a mensagem

            // 2. Pedir confirmação ao usuário
            int resposta = JOptionPane.showConfirmDialog(
                this, // Componente pai
                "Tem certeza que deseja remover o animal '" + nomeAnimal + "' (ID: " + idParaRemover + ")?\nEsta ação não pode ser desfeita.", // Mensagem
                "Confirmar Remoção", // Título da janela
                JOptionPane.YES_NO_OPTION, // Tipo de botões
                JOptionPane.QUESTION_MESSAGE // Ícone
            );

            // 3. Verificar a resposta e agir
            if (resposta == JOptionPane.YES_OPTION) {
                // Se o usuário clicou em "Sim", chama o método do gestor
                boolean removidoComSucesso = gestor.removerAnimal(idParaRemover);

                if (removidoComSucesso) {
                    JOptionPane.showMessageDialog(this, "Animal removido com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                    // Atualiza a tabela e limpa o formulário
                    atualizarTabela();
                    limparCampos(); // Usando o método que criamos anteriormente
                } else {
                    // Isso não deveria acontecer se a lógica estiver correta, mas é uma segurança extra
                    JOptionPane.showMessageDialog(this, "Erro: O animal selecionado não foi encontrado na lista de dados.", "Erro de Remoção", JOptionPane.ERROR_MESSAGE);
                }
            }
            // Se o usuário clicou em "Não", o método simplesmente termina e nada acontece.

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O ID do animal na tabela é inválido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro inesperado durante a remoção.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Imprime o erro detalhado no console para depuração
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed
    
    // Botão para cancelar uma operação
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limparCampos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        TelaExame exame = new TelaExame(this.gestor);
        exame.setLocationRelativeTo(null);
        exame.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton4ActionPerformed
    
    // Butão para pesquisar animal pelo ID
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // 1. Obter e validar o texto do campo de pesquisa
        String textoId = pesquisarId.getText().trim();

        if (textoId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, digite um ID para pesquisar.", "Campo Vazio", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int idPesquisa = Integer.parseInt(textoId);

            // 2. Chamar o método de busca na classe de lógica
            Animal animalEncontrado = gestor.buscarAnimalPorId(idPesquisa);

            // 3. Processar o resultado
            if (animalEncontrado != null) {
                // Se encontrou o animal, vamos encontrar a linha correspondente na JTable
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    // Pega o ID da primeira coluna (coluna 0) da tabela
                    int idNaTabela = Integer.parseInt(jTable1.getValueAt(i, 0).toString());

                    if (idNaTabela == idPesquisa) {
                        // ENCONTRAMOS A LINHA!

                        // Seleciona a linha na tabela
                        jTable1.setRowSelectionInterval(i, i);

                        // Rola a tabela para que a linha selecionada fique visível (útil para listas grandes)
                        jTable1.scrollRectToVisible(jTable1.getCellRect(i, 0, true));

                        return; // Para o loop e o método, pois já encontramos o que queríamos
                    }
                }
            } else {
                // Se o método de busca retornou null, o animal não existe
                JOptionPane.showMessageDialog(this, "Nenhum animal encontrado com o ID " + idPesquisa + ".", "Não Encontrado", JOptionPane.INFORMATION_MESSAGE);
                jTable1.clearSelection(); // Limpa qualquer seleção anterior da tabela
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O ID deve ser um número válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_jButton6ActionPerformed

    
    //Botão para criar animal
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // 1. Pegar dados da interface
            int id = Integer.parseInt(jTextField1.getText());
            String nome = jTextField2.getText();
            String especie = jTextField3.getText();
            Alimento alimentoSelecionado = (Alimento) jComboBox1.getSelectedItem();
            boolean estaDoente = jRadioButton1.isSelected(); // jRadioButton1 é "Doente"
            boolean estaComFome = jRadioButton3.isSelected(); // jRadioButton3 é "Sim"
            
            // Validação simples
            if (nome.isEmpty() || especie.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nome e Espécie são obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 2. Criar objeto Animal (Assumindo que você tenha um construtor assim)
            Animal novoAnimal = new Animal(id, nome, especie, alimentoSelecionado, estaDoente, estaComFome);

            // 3. Chamar o método do gestor
            boolean foiAdicionado = gestor.adicionarAnimal(novoAnimal);
            
            if(foiAdicionado){
                JOptionPane.showMessageDialog(this, "Animal adicionado com sucesso!");
            }
            else{
                JOptionPane.showMessageDialog(this, "Já existe um animal cadastrado com esse ID", "Erro", JOptionPane.ERROR_MESSAGE);

            }

            // 4. Atualizar a tabela
            atualizarTabela();

            // 5. Limpar campos
            limparCampos();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O ID deve ser um número válido.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    // Botão para editar
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            // 1. Pegar dados da interface
            // O ID não deve ser editável pelo usuário, ele vem do animal selecionado.
            int id = Integer.parseInt(jTextField1.getText()); 

            String nome = jTextField2.getText();
            String especie = jTextField3.getText();
            boolean estaDoente = jRadioButton1.isSelected(); // Assumindo que jRadioButton1 é "Doente"
            boolean estaComFome = jRadioButton3.isSelected(); // Assumindo que jRadioButton3 é "Sim" (Com Fome)

            // 2. Validação simples de campos obrigatórios
            if (nome.trim().isEmpty() || especie.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Os campos Nome e Espécie não podem estar vazios.", "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // 3. Chamar o método do gestor e verificar o resultado
            boolean editadoComSucesso = gestor.editarAnimal(id, nome, especie, estaDoente, estaComFome);

            // 4. Mostrar feedback ao usuário e atualizar a interface
            if (editadoComSucesso) {
                JOptionPane.showMessageDialog(this, "Animal editado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                // Atualiza a tabela para refletir a mudança
                atualizarTabela(); 

                // Limpa os campos do formulário
                limparCampos(); // É uma boa prática criar um método para isso

            } else {
                // Esta mensagem aparecerá se o ID nos campos não corresponder a nenhum animal na lista
                JOptionPane.showMessageDialog(this, "Animal com ID " + id + " não foi encontrado. Não foi possível editar.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "O ID do animal é inválido ou não foi carregado. Selecione um animal da tabela primeiro.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro inesperado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int linhaSelecionada = jTable1.getSelectedRow();

        if (linhaSelecionada != -1) {
            try {
                // Lendo os dados da tabela na ORDEM CORRETA
                String id = jTable1.getValueAt(linhaSelecionada, 0).toString();
                String nome = jTable1.getValueAt(linhaSelecionada, 1).toString();
                String especie = jTable1.getValueAt(linhaSelecionada, 2).toString();

                // ==================== CORREÇÃO AQUI ====================
                // 1. Ler o objeto Alimento da coluna 3
                Alimento alimento = (Alimento) jTable1.getValueAt(linhaSelecionada, 3);

                // 2. Ler os valores de Doente e Fome das colunas seguintes (4 e 5)
                boolean doente = Boolean.parseBoolean(jTable1.getValueAt(linhaSelecionada, 4).toString());
                boolean comFome = Boolean.parseBoolean(jTable1.getValueAt(linhaSelecionada, 5).toString());
                // =======================================================

                // Agora, preenchemos TODOS os campos da interface
                jTextField1.setText(id);
                jTextField2.setText(nome);
                jTextField3.setText(especie);

                // Seleciona o item correto no ComboBox
                jComboBox1.setSelectedItem(alimento);

                // Seleciona os radio buttons corretos
                if (doente) {
                    jRadioButton1.setSelected(true);
                } else {
                    jRadioButton2.setSelected(true);
                }

                if (comFome) {
                    jRadioButton3.setSelected(true);
                } else {
                    jRadioButton4.setSelected(true);
                }

            } catch (Exception e) {
                System.err.println("Ocorreu um erro ao carregar os dados da tabela para o formulário.");
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao ler os dados da linha selecionada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAnimal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<Alimento> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField pesquisarId;
    // End of variables declaration//GEN-END:variables
}
