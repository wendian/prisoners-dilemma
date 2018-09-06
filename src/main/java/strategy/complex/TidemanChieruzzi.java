package strategy.complex;

import java.util.ArrayList;

import actions.Action;
import board.Board;

public class TidemanChieruzzi extends ComplexStrategy {
    
    private int maxRetaliations = 1;
    private int retaliations = 0;
    private int turnsSinceNew = -1;
    private int freshStartCounter = 1;
    private int opponentDefects = 0;

    @Override
    public String getName() {
        return "Tideman and Chieruzzi";
    }

    @Override
    public String getShortName() {
        return "TiCh";
    }

    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        updateScores(board, ownHistory, opponentHistory);
        turnsSinceNew++;
        if (freshStartCounter > 0) {
            freshStartCounter--;
            return Action.COOPERATE;
        }
        int turn = ownHistory.size() - 1;
        if (opponentHistory.get(turn) == Action.DEFECT) {
            retaliations = maxRetaliations;
            maxRetaliations++;
        }
        if (retaliations > 0) {
            retaliations--;
            return Action.DEFECT;
        }
        if (timeForForgiveness(opponentHistory)) {
            System.out.println("FOGRIV");
            maxRetaliations = 1;
            retaliations = 0;
            turnsSinceNew = 0;
            freshStartCounter = 3;
        }
        return Action.COOPERATE;
    }
    
    private boolean timeForForgiveness( ArrayList<Integer> opponentHistory) {
        int turn = opponentHistory.size() - 1;
        return (myScore - opponentScore > 10)
                && (opponentHistory.get(turn) != Action.DEFECT)
                && (turnsSinceNew > 20)
                && opponentIsNotEvil(opponentHistory);
    }

    private boolean opponentIsNotEvil(ArrayList<Integer> opponentHistory) {
        int n = opponentHistory.size();
        double mean = n / 2;
        double stdv = Math.sqrt(n / 4);
        return (mean - (3 * stdv) > opponentDefects);
    }

    @Override
    public void reset() {
        super.reset();
        maxRetaliations = 1;
        retaliations = 0;
        freshStartCounter = 1;
        turnsSinceNew = -1;
        opponentDefects = 0;
    }
    
    @Override
    protected int updateScores(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int turn = super.updateScores(board, ownHistory, opponentHistory);
        if (turn > 0 && opponentHistory.get(turn) == Action.DEFECT) {
            opponentDefects++;
        }
        return turn;
    }
}
