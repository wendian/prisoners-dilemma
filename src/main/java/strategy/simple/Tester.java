package strategy.simple;

import java.util.ArrayList;
import java.util.Stack;

import actions.Action;
import board.Board;
import strategy.Strategy;

public class Tester extends Strategy {
    
    private Stack<Integer> moves = new Stack<>();
    private Strategy strategy;
    
    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int turn = opponentHistory.size();
        if (turn == 0) {
            reset();
        }
        if (!moves.isEmpty()) {
            return moves.pop();
        }
        if (strategy == null) {
            if (opponentHistory.get(turn - 1) == Action.COOPERATE) {
                moves.push(Action.DEFECT);
            } else {
                strategy = new TitForTat();
            }
            return Action.COOPERATE;
        }
        return strategy.makeChoice(board, ownHistory, opponentHistory);
    }

    @Override
    public String getName() {
        return "Tester";
    }
    
    @Override
    public String getShortName() {
        return "TEST";
    }
    
    @Override
    public void reset() {
        moves.clear();
        moves.push(Action.COOPERATE);
        moves.push(Action.DEFECT);
        strategy = null;
    }
}
