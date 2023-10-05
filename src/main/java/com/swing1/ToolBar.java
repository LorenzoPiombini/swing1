package com.swing1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel implements ActionListener {

    private JButton helloBtn;
    private JButton goodByeBtn;
    private StringListener textListener;

    public ToolBar() {
        helloBtn = new JButton("Hello");
        goodByeBtn = new JButton("Goodbye");

        helloBtn.addActionListener(this);
        goodByeBtn.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloBtn);
        add(goodByeBtn);

    }

    public void setStringListener(StringListener listener) {
        this.textListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        if (clicked == helloBtn) {
            if (textListener != null)
                textListener.textEmited("Hello\n");
        }

        if (clicked == goodByeBtn) {
            if (textListener != null)
                textListener.textEmited("Goodbye\n");
        }

    }
}
