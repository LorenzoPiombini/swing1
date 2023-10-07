package com.swing1;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPannel extends JPanel {

    private JLabel nameLabel;
    private JLabel occpuationLabel;

    private JTextField nameFiled;
    private JTextField occupationField;
    private JButton okBtn;
    private FormListner formListner;

    public FormPannel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occpuationLabel = new JLabel("Occupation: ");
        nameFiled = new JTextField(10);
        occupationField = new JTextField(10);
        okBtn = new JButton("OK");

        okBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameFiled.getText();
                String occupationName = occupationField.getText();

                FormEvent ev = new FormEvent(this, name, occupationName);

                if (formListner != null) {
                    formListner.formEventOccured(ev);
                }
            }

        });

        Border innerBoarder = BorderFactory.createTitledBorder("Add person");
        Border outBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setBorder(BorderFactory.createCompoundBorder(innerBoarder, outBorder));

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        // first row//

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameFiled, gc);

        ////// second row //////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(occpuationLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        // third row/////
        gc.weightx = 1;
        gc.weighty = 2;
        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);

    }

    public void setFormlistener(FormListner listner) {
        this.formListner = listner;
    }
}
