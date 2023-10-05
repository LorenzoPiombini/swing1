package com.swing1;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

    private TextPannel textPannel;
    private ToolBar toolBar;

    public MainFrame() {

        super("Hello World");

        setLayout(new BorderLayout());

        toolBar = new ToolBar();
        textPannel = new TextPannel();

        toolBar.setStringListener(new StringListener() {

            @Override
            public void textEmited(String text) {
                textPannel.appendText(text);
            }

        });

        add(toolBar, BorderLayout.NORTH);
        add(textPannel, BorderLayout.CENTER);

        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
