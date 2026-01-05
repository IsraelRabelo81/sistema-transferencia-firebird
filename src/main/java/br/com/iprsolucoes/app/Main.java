package br.com.iprsolucoes.app;

import br.com.iprsolucoes.view.MainFrame;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                criarEGuiarAplicacao();
            }
        });
    }

    private static void criarEGuiarAplicacao() {
        try {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);

            System.out.println("Aplicação Iniciada");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao carregar a aplicação: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        }
    }

}
