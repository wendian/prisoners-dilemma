package strategy.simple;

import java.util.ArrayList;

import actions.Action;
import board.Board;
import strategy.Strategy;

public class TitForTat extends Strategy {
    
    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int size = opponentHistory.size();
        int choice = Action.COOPERATE;
        if (size > 0) {
            choice = opponentHistory.get(size - 1);
        }
        return choice;
    }

    @Override
    public String getName() {
        return "Tit For Tat";
    }
    
    @Override
    public String getShortName() {
        return "T4T ";
    }
}
