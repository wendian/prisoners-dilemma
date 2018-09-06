package prisoner;

import board.Board;
import board.Reward;
import players.Player;
import players.PlayerA;
import players.PlayerB;

public class Game {

    public static final int NUMBER_OF_ROUNDS = 10;
    
    private Player playerA;
    private Player playerB;
    private Board board;
    
    public Game(PlayerA playerA, PlayerB playerB, Board board) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.board = board;
    }
    
    public void printBoard() {
        System.out.println(board.toString());
    }
    
    public void play() {
        int aChoice = playerA.getChoice(board, playerB.getHistory());
        int bChoice = playerB.getChoice(board, playerA.getHistory());
        Reward result = board.getReward(aChoice, bChoice);
        playerA.update(result);
        playerB.update(result);
    }
    

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        //stringBuilder.append("Player A Score: " + playerA.getScore() + "\nPlayer B Score: " + playerB.getScore() + '\n');
        stringBuilder.append("                " + playerA.getScoreHistoryString() + '\n');
        stringBuilder.append("Player A (" + playerA.getStrategy().getShortName() + "):" + playerA.getChoiceHistoryString() + '\n');
        stringBuilder.append("Player B (" + playerB.getStrategy().getShortName() + "):" + playerB.getChoiceHistoryString() + '\n');
        stringBuilder.append("                " + playerB.getScoreHistoryString() + '\n');
        stringBuilder.append(getWinner() + '\n');
        //stringBuilder.append(board.toString() + '\n');
        return stringBuilder.toString();
    }

    private String getWinner() {
        if (playerA.getScore() == playerB.getScore()) {
            return "Draw";
        }
        return (playerA.getScore() > playerB.getScore())
                ? "Winner is: " + playerA.getStrategy().getName() + " A"
                : "Winner is: " + playerB.getStrategy().getName() + " B";
    }

    public void reset() {
        playerA.reset();
        playerB.reset();
    }
}
