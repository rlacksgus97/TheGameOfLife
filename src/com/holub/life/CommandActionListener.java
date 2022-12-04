package com.holub.life;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class CommandActionListener implements ActionListener, Command {
    @Override
    public abstract void execute();

    @Override
    public void actionPerformed(ActionEvent e) {
        this.execute();
    }
}
