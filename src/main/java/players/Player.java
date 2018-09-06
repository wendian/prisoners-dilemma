package players;

import java.util.ArrayList;

import actions.Action;
import board.Board;
import board.Reward;
import prisoner.Game;
import strategy.Strategy;

public abstract class Player {    
    
    private Strategy strategy;
    private ArrayList<Integer> scores;
    private ArrayList<Integer> history;
    protected int choice;
    
    public Player(Strategy strategy) {
        this.strategy = strategy;
        scores = new ArrayList<>(Game.NUMBER_OF_ROUNDS);
        history = new ArrayList<>(Game.NUMBER_OF_ROUNDS);
        choice = -1;
    }
    
    public Player() {
        scores = new ArrayList<>(Game.NUMBER_OF_ROUNDS);
        history = new ArrayList<>(Game.NUMBER_OF_ROUNDS);
    }

    public abstract void update(Reward reward);
    
    public int getChoice(Board board, ArrayList<Integer> opponentHistory) {
        int choice = getStrategy().makeChoice(board, getHistory(), opponentHistory);
        this.choice = choice;
        return choice;
    }
    
    public int getScore() {
        int total = 0;
        for (Integer score : scores) {
            total += score;
        }
        return total;
    }
    
    protected void updateScore(int amount) {
        scores.add(amount);
    }
    
    public ArrayList<Integer> getHistory() {
        return history;
    }
    
    public Strategy getStrategy() {
        return strategy;
    }
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    
    public void reset() {
        if (strategy != null) {
            strategy.reset();
        }
        scores.clear();
        history.clear();
    }
    
    public String getScoreHistoryString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer score : scores) {
            stringBuilder.append(" | " + score);
        }
        stringBuilder.append(" ~ " + getScore());
        return stringBuilder.toString();
    }
    
    public String getChoiceHistoryString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer choice : history) {
            if (choice == Action.COOPERATE) {
                stringBuilder.append(" | C");
            } else {
                stringBuilder.append(" | D");
            }
        }
        return stringBuilder.toString();
    }
    
    public static void main(String[] args) {
        Player player = new PlayerA();
        player.updateScore(1);
        player.updateScore(1);

        player.updateScore(1);
        System.out.println(player.getScoreHistoryString());
    }
}
