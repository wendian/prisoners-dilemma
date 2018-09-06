package strategy.simple;

import java.util.ArrayList;

import actions.Action;
import board.Board;
import strategy.Strategy;

public class Pavlov extends Strategy {

    boolean isTesting = true;
    int choice = Action.COOPERATE;
    int cooperateScore = 0;
    int defectScore = 0;
    
    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int size = ownHistory.size();
        if (size > 0 && size <= 5) {
            cooperateScore += calculateLastRoundReward(board, ownHistory, opponentHistory);
        }
        if (size == 5) {
            choice = Action.DEFECT;
        }
        if (size > 5 && size <= 10) {
            defectScore += calculateLastRoundReward(board, ownHistory, opponentHistory);
        }
        if (size == 10) {
            choice = (cooperateScore > defectScore) ? Action.COOPERATE : Action.DEFECT;
        }
        return choice;
    }
    
    private int calculateLastRoundReward(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int last = ownHistory.size() - 1;
        int ownchoice = ownHistory.get(last);
        int opponentchoice = opponentHistory.get(last);
        return board.getReward(ownchoice, opponentchoice).getAReward();
    }
    
    @Override
    public String getName() {
        return "Pavlov";
    }
    
    @Override
    public String getShortName() {
        return "PAVL";
    }
    
    @Override
    public void reset() {
        isTesting = false;
        choice = Action.COOPERATE;
        cooperateScore = 0;
        defectScore = 0;
    }
}
