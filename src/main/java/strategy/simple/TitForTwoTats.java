package strategy.simple;

import java.util.ArrayList;

import actions.Action;
import board.Board;
import strategy.Strategy;

public class TitForTwoTats extends Strategy {
    
    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int size = opponentHistory.size();
        int choice = Action.COOPERATE;
        if (size >= 2) {
            if (opponentHistory.get(size - 1) == Action.DEFECT && opponentHistory.get(size - 2) == Action.DEFECT) {
                choice = Action.DEFECT;
            }
        }
        return choice;
    }

    @Override
    public String getName() {
        return "Tit For Two Tats";
    }
    
    @Override
    public String getShortName() {
        return "T42T";
    }
}
