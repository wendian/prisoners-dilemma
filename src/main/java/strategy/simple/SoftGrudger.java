package strategy.simple;

import java.util.ArrayList;
import java.util.Stack;

import actions.Action;
import board.Board;
import strategy.Strategy;

public class SoftGrudger extends Strategy {

    private Stack<Integer> punishment = new Stack<>();

    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int size = opponentHistory.size();
        int choice = Action.COOPERATE;
        if (size > 0 && punishment.isEmpty()) {
            if (opponentHistory.get(size - 1) == Action.DEFECT) {
                setupPunishment();
            }
        }
        if (!punishment.isEmpty()) {
            choice = punishment.pop();
        }
        return choice;
    }

    private void setupPunishment() {
        for (int i = 0; i < 2; i++) {
            punishment.push(Action.COOPERATE);
        }
        for (int i = 0; i < 4; i++) {
            punishment.push(Action.DEFECT);
        }
    }

    @Override
    public String getName() {
        return "Soft Grudger";
    }
    
    @Override
    public String getShortName() {
        return "SGRD";
    }
    
    @Override
    public void reset() {
        punishment.clear();
    }
}
