package tournament;

import java.util.Collections;

import board.Board;
import players.PlayerA;
import players.PlayerB;
import prisoner.Match;
import strategy.StrategyFactory;

public class Tournament {
    private static int gamesPlayed = 0;
    
    private PlayerA playerA;
    private PlayerB playerB;
    private ParticipantInfo participantInfo;
    private Board board;
    
    public Tournament(ParticipantInfo participantInfo, Board board) {
        this.participantInfo = participantInfo;
        playerA = new PlayerA();
        playerB = new PlayerB();
        this.board = board;
    }
    
    public void play() {
        for (Matchup matchup : participantInfo.getMatchups()) {
            playerA.setStrategy(matchup.getPlayerAStrategy());
            playerB.setStrategy(matchup.getPlayerBStrategy());
            //System.out.println(playerA.getStrategy().getName() + " vs. " + (playerB.getStrategy().getName()));
            Match match = new Match(playerA, playerB, board);
            match.play();
            //System.out.println(match.toString());
            match.reset();
            gamesPlayed++;
        }
        Collections.sort(participantInfo.getStrategies());
    }
    
    public void printFinalScores() {
        System.out.println("Strategies and scores:");
        System.out.println(participantInfo.toString());

        System.out.println("Total: " + gamesPlayed);
    }

    public ParticipantInfo getParticipantInfo() {
        return participantInfo;
    }

    public static void main(String[] args) {
        Population population = new Population(200);
        for (int i = 0; i < StrategyFactory.TOTAL_STRATEGIES; i++) {
            population.addStrategy(i, 5);
        }

        ParticipantInfo participantInfo = TournamentFactory.getParticipants(population);
        Tournament tournament = new Tournament(participantInfo, new Board(2, 0, 3, 1));
        //Tournament tournament = new Tournament(TournamentFactory.TEST_LATEST, StrategyFactory.getStrategy(StrategyFactory.GRUDGER));
        tournament.play();
        tournament.printFinalScores();
    }
}
