package br.com.iprsolucoes.view;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class DateFilterPanel extends JPanel {
    private JSpinner dataInicioSpinner;
    private JSpinner dataFimSpinner;
    private JButton aplicarFiltroButton;


    public DateFilterPanel() {
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Data Inicio:"), gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        dataInicioSpinner = createDateSpinner();
        add(dataInicioSpinner, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Data Fim:"), gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        dataFimSpinner = createDateSpinner();
        add(dataFimSpinner, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        aplicarFiltroButton = new JButton("Aplicar Filtro");
        aplicarFiltroButton.addActionListener(e -> aplicarFiltro());
        add(aplicarFiltroButton, gbc);
    }

    private JSpinner createDateSpinner() {
        SpinnerDateModel model = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
        JSpinner spinner = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy");
        spinner.setEditor(editor);
        return spinner;
    }

    private void aplicarFiltro() {
        Date dataInicio = (Date) dataInicioSpinner.getValue();
        Date dataFim = (Date) dataFimSpinner.getValue();

        if (dataInicio.after(dataFim)) {
            JOptionPane.showMessageDialog(this,
                    "Data inicio não pode ser maior que data fim!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this,
                "Filtro aplicado: " + dataInicio + " até " + dataFim,
                "Filtro",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public Date getDataInicio() {
        return (Date) dataInicioSpinner.getValue();
    }

    public Date getDataFim() {
        return (Date) dataFimSpinner.getValue();
    }
}
