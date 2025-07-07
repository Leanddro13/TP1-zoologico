package zoologico;

import zoologico.control.GestorZoologico;
import zoologico.view.TelaMenu;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatLightLaf;

public class Zoologico {
    public static void main(String[] args) {
        // Bloco para definir a aparência do Swing (opcional, mas bom ter aqui)
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
             System.err.println("Falha ao carregar o Look and Feel.");
        }

        // Lógica principal de inicialização
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // 1. Crie o "cérebro" da aplicação aqui
                GestorZoologico gestorCentral = new GestorZoologico();
                new TelaMenu(gestorCentral).setVisible(true);
            }
        });
    }
}