package strategy.simple;

import java.util.ArrayList;
import java.util.Stack;

import actions.Action;
import board.Board;
import strategy.Strategy;

public class Prober extends Strategy {
    
    private Stack<Integer> moves = new Stack<>();
    private Strategy strategy;
    
    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int turn = opponentHistory.size();
        int choice = Action.COOPERATE;
        if (turn == 0) {
            reset();
        }
        if (!moves.isEmpty()) {
            choice = moves.pop();
        }
        if (turn == 3) {
            if (opponentHistory.get(turn - 1) == Action.COOPERATE && opponentHistory.get(turn - 2) == Action.COOPERATE) {
                strategy = new AlwaysDefect();
            } else {
                strategy = new TitForTat();
            }
        }
        if (strategy != null) {
            choice = strategy.makeChoice(board, ownHistory, opponentHistory);
        }
        return choice;
    }

    @Override
    public String getName() {
        return "Prober";
    }
    
    @Override
    public String getShortName() {
        return "PROB";
    }
    
    @Override
    public void reset() {
        moves.clear();
        moves.push(Action.COOPERATE);
        moves.push(Action.COOPERATE);
        moves.push(Action.DEFECT);
        strategy = null;
    }
}
