package com.swing1;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPannel extends JPanel {

    private JLabel nameLabel;
    private JLabel occpuationLabel;

    private JTextField nameFiled;
    private JTextField occupationField;
    private JButton okBtn;
    private FormListner formListner;
    private JComboBox<String> empCombo;
    private JCheckBox citizenCheck;
    private JTextField taxField;
    private JLabel taxLbl;
    private JRadioButton maleRadio;
    private JRadioButton femaleRadio;
    private ButtonGroup genderGroup;

    private JList<String> ageList;

    public FormPannel() {
        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        nameLabel = new JLabel("Name: ");
        occpuationLabel = new JLabel("Occupation: ");
        nameFiled = new JTextField(10);
        occupationField = new JTextField(10);
        okBtn = new JButton("OK");
        ageList = new JList<>();
        empCombo = new JComboBox<>();
        citizenCheck = new JCheckBox();
        taxField = new JTextField(10);
        taxLbl = new JLabel("Tax ID: ");

        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");

        maleRadio.setActionCommand("male");
        femaleRadio.setActionCommand("female");

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        // setup tax id
        taxField.setEnabled(false);
        taxLbl.setEnabled(false);

        citizenCheck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isticked = citizenCheck.isSelected();
                taxLbl.setEnabled(isticked);
                taxField.setEnabled(isticked);
            }

        });

        // set uo combo box
        empCombo.setModel(new DefaultComboBoxModel<String>(new String[] { "employed", "selfEmploye", "unemployed" }));

        // set up list box
        DefaultListModel<String> ageModel = new DefaultListModel<>();
        ageModel.addElement("Under 18");
        ageModel.addElement("18 to 65");
        ageModel.addElement("65 or over");
        ageList.setModel(ageModel);

        ageList.setPreferredSize(new Dimension(110, 66));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(1);

        okBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameFiled.getText();
                String occupationName = occupationField.getText();
                AgeCategory ageCategory = new AgeCategory(ageList.getSelectedIndex(), ageList.getSelectedValue());
                String empCat = (String) empCombo.getSelectedItem();
                String taxId = taxField.getText();
                boolean usCitizen = citizenCheck.isSelected();

                String genderCommand = genderGroup.getSelection().getActionCommand();

                System.out.println(empCat);

                FormEvent ev = new FormEvent(this, name, occupationName, ageCategory.getId(), empCat, usCitizen, taxId,
                        genderCommand);

                if (formListner != null) {
                    formListner.formEventOccured(ev);
                }
            }

        });

        Border innerBoarder = BorderFactory.createTitledBorder("Add person");
        Border outBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);

        setBorder(BorderFactory.createCompoundBorder(innerBoarder, outBorder));

        layoutComponents();

    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        // next row/////

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

        // next row/////
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

        // next row/////
        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("age :"), gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(ageList, gc);

        // next row/////
        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.gridy = 3;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("employment :"), gc);

        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(empCombo, gc);

        // next row/////
        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.gridy = 4;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("Citizen: "), gc);

        gc.gridx = 1;
        gc.gridy = 4;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(citizenCheck, gc);

        // next row/////
        gc.weightx = 1;
        gc.weighty = 0.2;

        gc.gridx = 0;
        gc.gridy = 5;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(taxLbl, gc);

        gc.gridx = 1;
        gc.gridy = 5;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(taxField, gc);

        // next row/////
        gc.weightx = 1;
        gc.weighty = 0.05;

        gc.gridx = 0;
        gc.gridy = 6;
        gc.insets = new Insets(0, 0, 0, 5);
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        add(new JLabel("gender: "), gc);

        gc.gridx = 1;
        gc.gridy = 6;
        gc.anchor = GridBagConstraints.LINE_START;
        add(maleRadio, gc);

        gc.gridx = 1;
        gc.gridy = 7;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(femaleRadio, gc);

        // next row/////
        gc.weightx = 1;
        gc.weighty = 2;
        gc.gridx = 1;
        gc.gridy = 8;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);

    }

    public void setFormlistener(FormListner listner) {
        this.formListner = listner;
    }

    class AgeCategory {
        private int id;
        private String text;

        public AgeCategory(int id, String text) {
            this.id = id;
            this.text = text;
        }

        public String toString() {
            return text;
        }

        public int getId() {
            return id;
        }

    }

}
