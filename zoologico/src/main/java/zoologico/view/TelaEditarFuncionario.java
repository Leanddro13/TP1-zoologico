package zoologico.view;

import java.awt.Color;
import javax.swing.*;
import zoologico.model.Funcionario;
import zoologico.model.Setor;

public class TelaEditarFuncionario extends JDialog {

    private final TelaPrincipal telaPrincipal;
    private final Setor setor;
    private final Funcionario funcionario;
    private JTextField txtNome, txtMatricula, txtTelefone, txtEmail;
    private JRadioButton radioVet, radioZelador, radioGuia;
    
    public TelaEditarFuncionario(JFrame parent, Setor setor, Funcionario funcionario) {
        super(parent, "Editar Funcionário", true);
        this.telaPrincipal = (TelaPrincipal) parent;
        this.setor = setor;
        this.funcionario = funcionario;
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        initComponents();
        preencherDados();
        pack();
        setLocationRelativeTo(parent);
    }
    
    private void preencherDados() {
        txtMatricula.setText(String.valueOf(funcionario.getMatricula()));
        txtMatricula.setEditable(false);
        txtNome.setText(funcionario.getNome());
        txtTelefone.setText(funcionario.getTelefone());
        txtEmail.setText(funcionario.getEmail());
        
        String cargo = funcionario.getCargo();
        if ("Veterinário".equalsIgnoreCase(cargo)) radioVet.setSelected(true);
        else if ("Zelador".equalsIgnoreCase(cargo)) radioZelador.setSelected(true);
        else if ("Guia Turístico".equalsIgnoreCase(cargo)) radioGuia.setSelected(true);
    }

    private void initComponents() {
        JLabel lblNome = new JLabel("Nome");
        txtNome = new JTextField();
        JLabel lblMatricula = new JLabel("Matricula");
        txtMatricula = new JTextField();
        JLabel lblTelefone = new JLabel("Telefone");
        txtTelefone = new JTextField();
        JLabel lblEmail = new JLabel("Email");
        txtEmail = new JTextField();
        JLabel lblCargo = new JLabel("Cargo");
        radioVet = new JRadioButton("Veterinário");
        radioZelador = new JRadioButton("Zelador");
        radioGuia = new JRadioButton("Guia Turístico");
        ButtonGroup grupoCargo = new ButtonGroup();
        grupoCargo.add(radioVet);
        grupoCargo.add(radioZelador);
        grupoCargo.add(radioGuia);
        JButton btnRemover = new JButton("Remover");
        btnRemover.setBackground(new Color(255, 102, 102));
        btnRemover.setForeground(Color.WHITE);
        JButton btnSalvar = new JButton("Salvar");
        
        btnSalvar.addActionListener(e -> salvarAlteracoes());
        btnRemover.addActionListener(e -> remover());

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblNome)
                .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblMatricula)
                .addComponent(txtMatricula)
                .addComponent(lblTelefone)
                .addComponent(txtTelefone)
                .addComponent(lblEmail)
                .addComponent(txtEmail)
                .addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
            .addGap(50)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(lblCargo)
                .addComponent(radioVet)
                .addComponent(radioZelador)
                .addComponent(radioGuia)
                .addComponent(btnSalvar, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblNome)
                    .addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(10)
                    .addComponent(lblMatricula)
                    .addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(10)
                    .addComponent(lblTelefone)
                    .addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(10)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addComponent(lblCargo)
                    .addComponent(radioVet)
                    .addComponent(radioZelador)
                    .addComponent(radioGuia)))
            .addGap(30)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnRemover, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        );
    }
    
    private void salvarAlteracoes() {
        String cargo = "";
        if (radioVet.isSelected()) cargo = "Veterinário";
        else if (radioZelador.isSelected()) cargo = "Zelador";
        else if (radioGuia.isSelected()) cargo = "Guia Turístico";
        
        boolean sucesso = setor.editarFuncionario(
            funcionario.getMatricula(),
            txtNome.getText(),
            cargo,
            txtTelefone.getText(),
            txtEmail.getText()
        );
        
        if (sucesso) {
            new TelaDialogoSucesso(telaPrincipal, "Funcionário atualizado com sucesso.").setVisible(true);
            telaPrincipal.atualizarTabela();
            dispose();
        } else {
            new TelaDialogoFalha(telaPrincipal, "Falha ao atualizar o funcionário.").setVisible(true);
        }
    }
    
    private void remover() {
        int confirm = JOptionPane.showConfirmDialog(
            this,
            "Tem certeza que deseja remover este funcionário?",
            "Confirmar Remoção",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        
        if (confirm == JOptionPane.YES_OPTION) {
            boolean sucesso = setor.removerFuncionario(funcionario.getMatricula());
            if (sucesso) {
                new TelaDialogoSucesso(telaPrincipal, "Funcionário removido com sucesso.").setVisible(true);
                telaPrincipal.atualizarTabela();
                dispose();
            } else {
                new TelaDialogoFalha(telaPrincipal, "Falha ao remover o funcionário.").setVisible(true);
            }
        }
    }
}