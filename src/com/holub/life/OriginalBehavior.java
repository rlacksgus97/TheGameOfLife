package com.holub.life;

import java.awt.*;
import java.util.ArrayList;

public class OriginalBehavior implements BehaviorInterface{

    private static OriginalBehavior instance;

    private OriginalBehavior(){}

    public static OriginalBehavior getInstance(){
        if(instance==null){
            instance = new OriginalBehavior();
        }
        return instance;
    }

    @Override
    public void behavior(Cell outermostCell, ArrayList<Storable> state, int pointer) {
        Storable memento = outermostCell.createMemento();
        outermostCell.transfer(memento, new Point(0, 0), Cell.LOAD);
        state.add(memento);
    }
}
