package com.holub.life;

import java.awt.*;
import java.util.ArrayList;

public class AnotherBehavior implements BehaviorInterface {
    private static AnotherBehavior instance;

    private AnotherBehavior(){}

    public static AnotherBehavior getInstance(){
        if(instance==null){
            instance = new AnotherBehavior();
        }
        return instance;
    }

    @Override
    public void behavior(Cell outermostCell, ArrayList<Storable> state, int pointer) {
        Storable memento = state.get(pointer + 2);
        outermostCell.transfer(memento, new Point(0, 0), Cell.LOAD);
    }
}
