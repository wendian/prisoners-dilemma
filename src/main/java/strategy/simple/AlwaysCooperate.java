package strategy.simple;

import java.util.ArrayList;

import actions.Action;
import board.Board;
import strategy.Strategy;

public class AlwaysCooperate extends Strategy {
    
    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        return Action.COOPERATE;
    }

    @Override
    public String getName() {
        return "Always Cooperate";
    }
    
    @Override
    public String getShortName() {
        return "COOP";
    }
}
