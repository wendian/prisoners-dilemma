package tournament;

import java.util.ArrayList;
import java.util.Map.Entry;

import strategy.Strategy;
import strategy.StrategyFactory;

public class TournamentFactory {

    public static final int ROUND_ROBIN = 0;
    public static final int ONE_V_ALL = 1;
    public static final int TEST_LATEST = 2;
    
    public static ParticipantInfo getParticipants(Population population) {
        ParticipantInfo participantInfo = new ParticipantInfo();
        for (Entry<Integer, Integer> entry : population.getStrategies().entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                participantInfo.addNewStrategy(StrategyFactory.getStrategy(entry.getKey()));
            }
        }
        int size = participantInfo.getStrategies().size();
        ArrayList<Strategy> strategies = participantInfo.getStrategies();
        for (int j = 1; j < size; j++) {
            for (int i = 0; i < size - j; i++) {
                participantInfo.addMatchup(new Matchup(strategies.get(i), strategies.get(i + j)));
            }
        }
        return participantInfo;
    }
    
    public static Population getPopulation(ParticipantInfo participantInfo) {
        Population population = new Population(participantInfo.getStrategies().size());
        for (Strategy strategy : participantInfo.getStrategies()) {
            population.addStrategy(StrategyFactory.findStrategyId(strategy));
        }
        return population;
    }
}
