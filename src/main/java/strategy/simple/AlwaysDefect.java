package strategy.simple;

import java.util.ArrayList;

import actions.Action;
import board.Board;
import strategy.Strategy;

public class AlwaysDefect extends Strategy {
    
    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        return Action.DEFECT;
    }

    @Override
    public String getName() {
        return "Always Defect";
    }
    
    @Override
    public String getShortName() {
        return "DEFE";
    }
}
