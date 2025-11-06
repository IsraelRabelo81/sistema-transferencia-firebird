package br.com.iprsolucoes.view;

import javax.swing.*;
import java.awt.*;

public class CheckListPanel extends JPanel {
    private JCheckBox[] tableCheckboxes;
    private JButton transferButton;

    public CheckListPanel() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());

        JPanel tablesPanel = new JPanel(new GridLayout(0, 2));
        tablesPanel.setBorder(BorderFactory.createTitledBorder("Tabelas para Transferir"));

        String[] tables = {"CLIENTES", "PRODUTOS", "FORNECEDORES"};
        tableCheckboxes = new JCheckBox[tables.length];

        for(int i = 0; i < tables.length; i++) {
            tableCheckboxes[i] = new JCheckBox(tables[i]);
            tablesPanel.add(tableCheckboxes[i]);
        }

        JScrollPane scrollPane = new JScrollPane(tablesPanel);

        transferButton = new JButton("Iniciar Transferencia");
        transferButton.addActionListener(e -> iniciarTransferencia());

        add(scrollPane, BorderLayout.CENTER);
        add(transferButton, BorderLayout.SOUTH);
    }

    private void iniciarTransferencia() {
        JOptionPane.showMessageDialog(this, "Transferência iniciada!");
    }
}
