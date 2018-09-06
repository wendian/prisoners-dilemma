package strategy.simple;

import java.util.ArrayList;

import actions.Action;
import board.Board;
import strategy.Strategy;

public class SuspiciousTitForTat extends Strategy {
    
    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int size = opponentHistory.size();
        int choice = Action.DEFECT;
        if (size > 0) {
            choice = opponentHistory.get(size - 1);
        }
        return choice;
    }

    @Override
    public String getName() {
        return "Suspicious Tit For Tat";
    }
    
    @Override
    public String getShortName() {
        return "ST4T";
    }
}
