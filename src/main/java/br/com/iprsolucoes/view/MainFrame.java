package br.com.iprsolucoes.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private JTabbedPane tabbedPane;
    private CheckListPanel checkListPanel;
    private DateFilterPanel dateFilterPanel;
    private ConfigPanel configPanel;
    
    public MainFrame() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("STF - Sistema de transferencia Firebird");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();

        checkListPanel = new CheckListPanel();
        dateFilterPanel = new DateFilterPanel();
        configPanel = new ConfigPanel();

        tabbedPane.addTab("Checklist", checkListPanel);
        tabbedPane.add("Filtro de datas", dateFilterPanel);
        tabbedPane.add("Configurações", configPanel);

        add(tabbedPane);

        //setupSystemTray();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    private void setupSystemTray() {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            Image image = Toolkit.getDefaultToolkit().getImage("resources/icons/app_icon.png");

            PopupMenu popup = new PopupMenu();
            MenuItem openIten = new MenuItem("Abrir");
            MenuItem exitItem = new MenuItem("Sair");

            openIten.addActionListener(e -> {
                setVisible(true);
                setExtendedState(JFrame.NORMAL);
            });

            exitItem.addActionListener(e-> {
                System.exit(0);
            });

            popup.add(openIten);
            popup.add(exitItem);

            TrayIcon trayIcon = new TrayIcon(image, "Firebird Transfer", popup);
            trayIcon.setImageAutoSize(true);

            addWindowStateListener(e -> {
                if(e.getNewState() == ICONIFIED) {
                    setVisible(false);
                    try{
                        tray.add(trayIcon);
                    } catch (AWTException ex) {
                        ex.printStackTrace();
                    }
                }
            });

            trayIcon.addActionListener(e-> {
                tray.remove(trayIcon);
                setVisible(true);
                setExtendedState(JFrame.NORMAL);
            });
        }
    }

}
