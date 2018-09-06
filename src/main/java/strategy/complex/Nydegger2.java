package strategy.complex;

import java.util.ArrayList;
import java.util.HashSet;

import actions.Action;
import board.Board;

public class Nydegger2 extends ComplexStrategy {
    
    private static final int[][] aVals = {
            { 0, 1 },
            { 2, 3 }
        };

    private static HashSet<Integer> a = new HashSet<>();
    static {
        a.add(1);
        a.add(6);
        a.add(7);
        a.add(17);
        a.add(22);
        a.add(23);
        a.add(26);
        a.add(29);
        a.add(30);
        a.add(31);
        a.add(33);
        a.add(38);
        a.add(39);
        a.add(45);
        a.add(49);
        a.add(54);
        a.add(55);
        a.add(58);
        a.add(61);
    };
    
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
        int lastTurn = ownHistory.size() - 1;
        if (lastTurn == -1) {
            return Action.COOPERATE;
        }
        if (lastTurn == 0) {
            return opponentHistory.get(lastTurn);
        }
        if (lastTurn == 1) {
            if (ownHistory.get(lastTurn) == Action.DEFECT && opponentHistory.get(lastTurn) == Action.COOPERATE) {
                return Action.DEFECT;
            }
            return opponentHistory.get(lastTurn);
        }
        int a1 = calculate(ownHistory.get(lastTurn), opponentHistory.get(lastTurn));
        int a2 = calculate(ownHistory.get(lastTurn - 1), opponentHistory.get(lastTurn - 1));
        int a3 = calculate(ownHistory.get(lastTurn - 2), opponentHistory.get(lastTurn - 2));
        int res = (a1 * 16) + (a2 * 4) + a3;
        System.out.println("16 * " + a1 + " + 4 * " + a2 + " + " + a3 + " = " + res);
        if (a.contains((a1 * 16) + (a2 * 4) + a3)) {
            return Action.DEFECT;
        }
        return Action.COOPERATE;
    }

    private int calculate(int ownChoice, int opponentChoice) {
        return aVals[ownChoice][opponentChoice];
    }
}
