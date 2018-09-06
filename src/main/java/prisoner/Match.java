package prisoner;

import board.Board;
import players.PlayerA;
import players.PlayerB;
import strategy.StrategyFactory;

public class Match {

    private static final int GAMES = 50;
    
    private Game game;
    
    public Match(PlayerA playerA, PlayerB playerB, Board board) {
        this.game = new Game(playerA, playerB, board);
    }

    @Override
    public String toString() {
        return game.toString();
    }

    public void play() {
        for (int i = 0; i < GAMES; i++) {
            System.out.println(game.toString());
            game.play();
        }
    }
    
    public void reset() {
        game.reset();
    }
    
    public static void main(String[] args) {
        //PlayerA playerA = new PlayerA(StrategyFactory.getStrategy(StrategyFactory.TOTAL_STRATEGIES - 1));
        PlayerA playerA = new PlayerA(StrategyFactory.getStrategy(StrategyFactory.GROFMAN));
        PlayerB playerB = new PlayerB(StrategyFactory.getStrategy(StrategyFactory.STIT4TAT));
        Board board = new Board(2, 0, 3, 1);
        Match match = new Match(playerA, playerB, board);
        match.play();
        System.out.println(match.toString());
    }
}
