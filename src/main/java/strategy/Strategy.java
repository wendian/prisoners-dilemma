package strategy;

import java.util.ArrayList;

import board.Board;

public abstract class Strategy implements Comparable<Strategy> {
    
    private int totalScore = 0;
    
    public abstract String getName();
    
    public abstract String getShortName();
    
    public int getGlobalScore() {
        return totalScore;
    }

    public void updateGlobalScore(int amount) {
        totalScore += amount;
    }
    
    public abstract int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory);
    
    public void reset() { }
    
    @Override
    public int compareTo(Strategy other) {
        return other.getGlobalScore() - getGlobalScore();
    }
}
