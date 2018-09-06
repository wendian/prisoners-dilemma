package strategy.random;

import java.util.ArrayList;

import actions.Action;
import board.Board;

public class RandomAI extends RandomizedStrategy {

    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        return randomize(Action.COOPERATE, 50);
    }

    @Override
    public String getName() {
        return "Random";
    }
    
    
    @Override
    public String getShortName() {
        return "RAND";
    }
}
