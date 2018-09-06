package tournament;

import board.Board;
import strategy.StrategyFactory;

public class Epoch {
    private static final int GENERATIONS = 20;
    
    private Population population;
    private Board board;
    
    public Epoch(Population population, Board board) {
        this.population = population;
        this.board = board;
    }
    
    public void play() {
        for (int i = 0; i < GENERATIONS; i++) {
            System.out.println("Generation " + i + " strategies:");
            System.out.println(population.toString());
            ParticipantInfo participantInfo = TournamentFactory.getParticipants(population);
            Tournament tournament = new Tournament(participantInfo, board);
            tournament.play();
            //System.out.println("Generation " + i + " results:");
            //System.out.println(tournament.getParticipantInfo().toString());
            population = Evolution.getNextGeneration(participantInfo);
        }
    }
    
    public static void main(String[] args) {
        int strategies = 50;
        Population population = new Population(34);
        population.addStrategy(StrategyFactory.DEFECT, 30);
        //population.addStrategy(StrategyFactory.COOPERATE, 3);
        population.addStrategy(StrategyFactory.TIT4TAT, 2);
        //population.addStrategy(StrategyFactory.GRUDGER, 3);
        //population.addStrategy(StrategyFactory.TIT42TAT, 3);
        //population.addStrategy(StrategyFactory.STIT4TAT, 3);
        //for (int i = 0; i < StrategyFactory.TOTAL_STRATEGIES; i++) {
        //    population.addStrategy(i, strategies);
        //}
        Epoch epoch = new Epoch(population, new Board(2, 0, 3, 1));
        epoch.play();
    }
}
