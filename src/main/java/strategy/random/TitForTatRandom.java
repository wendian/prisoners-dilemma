package strategy.random;

import java.util.ArrayList;

import actions.Action;
import board.Board;

public class TitForTatRandom extends RandomizedStrategy {
    
    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int size = opponentHistory.size();
        int choice = Action.COOPERATE;
        if (size > 0) {
            choice = opponentHistory.get(size - 1);
        }
        return randomize(choice, 12);
    }

    @Override
    public String getName() {
        return "Tit For Tat Random";
    }
    
    @Override
    public String getShortName() {
        return "T4TR";
    }
}
