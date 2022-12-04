package com.holub.life;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandActionListener implements ActionListener {
    private Command command;

    CommandActionListener(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.command.execute();
    }
}
