package strategy.complex;

import java.util.ArrayList;

import actions.Action;
import board.Board;
import strategy.random.RandomizedStrategy;

public class Grofman extends RandomizedStrategy {

    @Override
    public String getName() {
        return "Grofman";
    }

    @Override
    public String getShortName() {
        return "GROF";
    }

    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int turn = ownHistory.size();
        if (turn < 2) {
            return Action.COOPERATE;
        }
        if (turn < 7) {
            return opponentHistory.get(turn - 1);
        }
        if (ownHistory.get(turn - 1) == opponentHistory.get(turn - 1)) {
            return Action.COOPERATE;
        }
        return randomize(Action.COOPERATE, 28);
    }

}
