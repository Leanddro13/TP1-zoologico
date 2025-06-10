package zoologico.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Random;
import javax.swing.*;
import zoologico.model.Funcionario;
import zoologico.model.Setor;

public class TelaCriarFuncionario extends JDialog {

    private final TelaPrincipal telaPrincipal;
    private final Setor setor;
    private JTextField txtMatricula, txtNome, txtTelefone, txtEmail;
    private JRadioButton radioVet, radioZelador, radioGuia;

    public TelaCriarFuncionario(JFrame parent, Setor setor) {
        super(parent, "Adicionar Funcionário", true);
        this.telaPrincipal = (TelaPrincipal) parent;
        this.setor = setor;
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        initComponents();
        pack();
        setLocationRelativeTo(parent);
    }
    
    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0; add(new JLabel("Matrícula:"), gbc);
        JPanel painelMatricula = new JPanel();
        txtMatricula = new JTextField(10);
        JButton btnGerar = new JButton("Gerar");
        btnGerar.addActionListener(e -> txtMatricula.setText(String.valueOf(new Random().nextInt(90000) + 10000)));
        painelMatricula.add(txtMatricula);
        painelMatricula.add(btnGerar);
        gbc.gridx = 1; gbc.gridy = 0; add(painelMatricula, gbc);

        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Nome:"), gbc);
        txtNome = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 1; add(txtNome, gbc);

        gbc.gridx = 0; gbc.gridy = 2; add(new JLabel("Telefone:"), gbc);
        txtTelefone = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 2; add(txtTelefone, gbc);

        gbc.gridx = 0; gbc.gridy = 3; add(new JLabel("Email:"), gbc);
        txtEmail = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 3; add(txtEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 4; add(new JLabel("Cargo:"), gbc);
        radioVet = new JRadioButton("Veterinário");
        radioZelador = new JRadioButton("Zelador");
        radioGuia = new JRadioButton("Guia Turístico");
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioVet);
        grupo.add(radioZelador);
        grupo.add(radioGuia);
        JPanel painelRadios = new JPanel();
        painelRadios.add(radioVet);
        painelRadios.add(radioZelador);
        painelRadios.add(radioGuia);
        gbc.gridx = 1; add(painelRadios, gbc);
        radioVet.setSelected(true);
        
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> salvarFuncionario());
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; gbc.anchor = GridBagConstraints.CENTER;
        add(btnSalvar, gbc);
    }
    
    private void salvarFuncionario() {
        try {
            int matricula = Integer.parseInt(txtMatricula.getText());
            String nome = txtNome.getText();
            String telefone = txtTelefone.getText();
            String email = txtEmail.getText();
            
            String cargo = "";
            if (radioVet.isSelected()) cargo = "Veterinário";
            else if (radioZelador.isSelected()) cargo = "Zelador";
            else if (radioGuia.isSelected()) cargo = "Guia Turístico";
            
            Funcionario f = new Funcionario(matricula, nome, cargo, telefone, email);
            setor.adicionarFuncionario(f);
            
            new TelaDialogoSucesso(telaPrincipal, "Funcionário cadastrado com sucesso.").setVisible(true);
            telaPrincipal.atualizarTabela();
            dispose();
        } catch (Exception ex) {
            new TelaDialogoFalha(telaPrincipal, "Erro ao salvar: " + ex.getMessage()).setVisible(true);
        }
    }
}