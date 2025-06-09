package zoologico.view;

import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.*;

public class TelaDialogoSucesso extends JDialog {
    public TelaDialogoSucesso(Frame parent, String mensagem) {
        super(parent, "Sucesso", true);
        setLayout(new BorderLayout(10, 10));
        
        JLabel lblMensagem = new JLabel(mensagem, SwingConstants.CENTER);
        JPanel painelMsg = new JPanel();
        painelMsg.add(lblMensagem);
        
        JButton btnOk = new JButton("OK");
        btnOk.addActionListener(e -> dispose());
        
        JPanel painelBotao = new JPanel();
        painelBotao.add(btnOk);
        
        add(painelMsg, BorderLayout.CENTER);
        add(painelBotao, BorderLayout.SOUTH);
        
        pack();
        setMinimumSize(new java.awt.Dimension(300, 120));
        setLocationRelativeTo(parent);
    }
}