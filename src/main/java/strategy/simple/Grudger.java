package strategy.simple;

import java.util.ArrayList;

import actions.Action;
import board.Board;
import strategy.Strategy;

public class Grudger extends Strategy {
    
    private boolean hasBeenBetrayed = false;

    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int size = opponentHistory.size();
        if (size > 0) {
            hasBeenBetrayed = hasBeenBetrayed || opponentHistory.get(size - 1) == Action.DEFECT;
        }
        return hasBeenBetrayed ? Action.DEFECT : Action.COOPERATE;
    }

    @Override
    public String getName() {
        return "Grudger";
    }
    
    @Override
    public String getShortName() {
        return "GRUD";
    }
    
    @Override
    public void reset() {
        hasBeenBetrayed  = false;
    }
}
