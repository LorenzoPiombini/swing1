package com.swing1;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private TextPannel textPannel;
    private ToolBar toolBar;
    private FormPannel formPannel;

    public MainFrame() {

        super("Hello World");

        setLayout(new BorderLayout());

        toolBar = new ToolBar();
        textPannel = new TextPannel();
        formPannel = new FormPannel();

        toolBar.setStringListener(new StringListener() {

            @Override
            public void textEmited(String text) {
                textPannel.appendText(text);
            }

        });

        formPannel.setFormlistener(new FormListner() {
            public void formEventOccured(FormEvent e) {
                String name = e.getName();
                String occupation = e.getOccupation();
                int ageCat = e.getAgeCategory();
                String empCat = e.getEmpCat();

                textPannel.appendText(
                        name + " : " + occupation + ": age: " + ageCat + "Employment category: " + empCat + "\n");
            }
        });

        add(toolBar, BorderLayout.NORTH);
        add(textPannel, BorderLayout.CENTER);
        add(formPannel, BorderLayout.WEST);

        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
