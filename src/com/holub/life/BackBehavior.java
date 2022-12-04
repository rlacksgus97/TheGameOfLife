package com.holub.life;

import java.awt.*;
import java.util.ArrayList;

public class BackBehavior implements BehaviorInterface {

    private static BackBehavior instance;

    private BackBehavior(){}

    public static BackBehavior getInstance(){
        if(instance==null){
            instance = new BackBehavior();
        }
        return instance;
    }

    @Override
    public void behavior(Cell outermostCell, ArrayList<Storable> state, int pointer) {
        Storable memento = state.get(pointer);
        outermostCell.transfer(memento, new Point(0, 0), Cell.LOAD);
    }
}
