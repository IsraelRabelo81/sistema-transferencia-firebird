package br.com.iprsolucoes.view;

import br.com.iprsolucoes.config.DatabaseConfig;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigPanel extends JPanel {
    private DatabaseConfig config;

    //Banco de origem
    private JTextField sourceHostField;
    private JTextField sourcePortField;
    private JTextField sourceDatabaseField;
    private JTextField sourceUserField;
    private JPasswordField sourcePassField;

    //Banco destino
    private JTextField targetHostField;
    private JTextField targetDatabaseField;
    private JTextField targetPortField;
    private JTextField targetUserField;
    private JPasswordField targetPassField;

    private JButton testSourceButton;
    private JButton testTargetButton;
    private JButton saveButton;

    public ConfigPanel() {
        this.config = new DatabaseConfig();
        initializeUI();
        loadConfig();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        JTabbedPane configTabs = new JTabbedPane();
        configTabs.addTab("Banco Origem", createSourcePanel());
        configTabs.addTab("Banco Destino", createTargetPanel());
        configTabs.addTab("Configurações", createSettingsPanel());

        add(configTabs, BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private JPanel createSourcePanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        //host source
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Host:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        sourceHostField = new JTextField(20);
        panel.add(sourceHostField, gbc);

        //porta source
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Porta:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        sourcePortField = new JTextField("3050", 10);
        panel.add(sourcePortField, gbc);

        //database source
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Database:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        sourceDatabaseField = new JTextField(30);
        panel.add(sourceDatabaseField, gbc);

        //usuario sorce
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Usuario:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        sourceUserField = new JTextField(15);
        panel.add(sourceUserField, gbc);

        //senha source
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        sourcePassField = new JPasswordField(15);
        panel.add(sourcePassField, gbc);

        //botão source
        gbc.gridx = 1; gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        testSourceButton = new JButton("Testar Conexão");
        testSourceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testSourceConnection();
            }
        });
        panel.add(testSourceButton, gbc);

        return panel;
    }



    private JPanel createTargetPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        //host target
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Host:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        targetHostField = new JTextField(20);
        panel.add(targetHostField, gbc);

        //porta target
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Porta:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        targetPortField = new JTextField("3050",10);
        panel.add(targetPortField, gbc);

        //database target
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Database:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        targetDatabaseField = new JTextField(30);
        panel.add(targetDatabaseField, gbc);

        //usuario target
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Usuario:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        targetUserField = new JTextField(15);
        panel.add(targetUserField, gbc);

        //senha target
        gbc.gridx = 0; gbc.gridy = row;
        panel.add(new JLabel("Senha:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        targetPassField = new JPasswordField(20);
        panel.add(targetPassField, gbc);

        //botão target
        gbc.gridx = 1; gbc.gridy = row++;
        testTargetButton = new JButton("Testar Conexão");
        testTargetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testTargetConnection();
            }
        });
        panel.add(testTargetButton, gbc);

        return panel;
    }

    private JPanel createSettingsPanel() {
        JPanel panel = new JPanel((new GridLayout(0, 1, 5, 5)));
        panel.setBorder(BorderFactory.createTitledBorder("Configurações Gerais"));
        panel.add(new JLabel("Configurações adicionais em desenvolvimento..."));

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        saveButton = new JButton("Salvar Configurações");
        saveButton.addActionListener(e -> saveConfig());

        JButton loadButton = new JButton("Carregar Padrões");
        loadButton.addActionListener(e -> loadDefaultConfig());

        panel.add(saveButton);
        panel.add(loadButton);

        return panel;
    }


    private void testSourceConnection() {
        //Teste de conexão banco de origem
        JOptionPane.showMessageDialog(this,
                "Teste de conexão banco de origem",
                "Teste de conexão",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void testTargetConnection() {
        //Teste de conexão banco de destino
        JOptionPane.showMessageDialog(this,
                "Teste de conexão banco de destino",
                "Teste de conexão",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void loadConfig() {
        sourceHostField.setText("localhost");
        sourcePortField.setText("3050");
        sourceUserField.setText("SYSDBA");
        sourcePassField.setText("masterkey");

        targetHostField.setText("localhost");
        targetPortField.setText("3050");
        targetUserField.setText("SYSDBA");
        targetPassField.setText("masterkey");
    }

    private void loadDefaultConfig() {
        int resposta = JOptionPane.showConfirmDialog(this,
                "Deseja carregar as configurações padrão?",
                "Carregar Padrões", JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {
            loadConfig();
        }
    }

    private void saveConfig() {
        JOptionPane.showMessageDialog(this,
                "Configurações salvas com sucesso!",
                "Salvar",
                JOptionPane.INFORMATION_MESSAGE);
    }


}
