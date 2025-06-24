package zoologico;

import zoologico.control.GestorZoologico;
import zoologico.view.TelaMenu;
import javax.swing.UIManager;


public class Zoologico {
    public static void main(String[] args) {
        // Bloco para definir a aparência do Swing (opcional, mas bom ter aqui)
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Zoologico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        // Lógica principal de inicialização
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // 1. Crie o "cérebro" da aplicação aqui
                GestorZoologico gestorCentral = new GestorZoologico();
                
                // Opcional: Adicionar dados iniciais para teste
                // gestorCentral.adicionarAnimal(...);

                // 2. Crie a tela principal e passe o gestor para ela
                new TelaMenu(gestorCentral).setVisible(true);
            }
        });
    }
}