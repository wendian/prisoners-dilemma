package strategy.complex;

import java.util.ArrayList;
import java.util.HashSet;

import actions.Action;
import board.Board;

public class Nydegger extends ComplexStrategy {
    
    private static HashSet<Integer> cooperateValues = new HashSet<>();
    static {
        cooperateValues.add(0);
        cooperateValues.add(27);
        cooperateValues.add(28);
        cooperateValues.add(32);
        cooperateValues.add(40);
        cooperateValues.add(41);
        cooperateValues.add(42);
        cooperateValues.add(43);
        cooperateValues.add(44);
        cooperateValues.add(46);
        cooperateValues.add(47);
        cooperateValues.add(48);
        cooperateValues.add(56);
        cooperateValues.add(57);
        cooperateValues.add(59);
        cooperateValues.add(60);
        cooperateValues.add(62);
        cooperateValues.add(63);
    };
    
    private int n = 0;
    
    @Override
    public String getName() {
        return "Nydegger";
    }

    @Override
    public String getShortName() {
        return "NYDG";
    }

    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int turn = ownHistory.size();
        int previousChoice = Action.COOPERATE;
        int opponentPreviousChoice = Action.COOPERATE;
        if (turn != 0) {
            previousChoice = ownHistory.get(turn - 1);
            opponentPreviousChoice = opponentHistory.get(turn -1);
        }
        n = (4 * (n - 16 * (n / 16))) + (2 * previousChoice) + opponentPreviousChoice;
        if (turn < 2) {
            return opponentPreviousChoice;
        }
        if (turn == 2 && n == 6) {
            return Action.DEFECT;
        }
        if (cooperateValues.contains(n)) {
            return Action.COOPERATE;
        } else {
            return Action.DEFECT;
        }
    }
    
    @Override
    public void reset() {
        n = 0;
    }
}
