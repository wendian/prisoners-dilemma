package strategy.complex;

import java.util.ArrayList;

import board.Board;
import board.Reward;
import strategy.Strategy;

public abstract class ComplexStrategy extends Strategy {
    protected int myScore = 0;
    protected int opponentScore = 0;

    @Override
    public abstract String getName();

    @Override
    public abstract String getShortName();

    @Override
    public abstract int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory);
    
    protected int updateScores(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        int turn = ownHistory.size() - 1;
        if (turn > 0) {
            Reward reward = board.getReward(ownHistory.get(turn), opponentHistory.get(turn));
            myScore += reward.getAReward();
            opponentScore += reward.getBReward();
        }
        return turn;
    }
    
    @Override
    public void reset() {
        myScore = 0;
        opponentScore = 0;
    }
}
