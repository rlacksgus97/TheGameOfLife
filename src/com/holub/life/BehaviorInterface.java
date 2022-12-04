package com.holub.life;

import java.util.ArrayList;

public interface BehaviorInterface {
    void behavior(Cell outermostCell, ArrayList<Storable> state, int pointer);
}
