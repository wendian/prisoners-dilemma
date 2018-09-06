package tournament;

import strategy.StrategyFactory;

public class Evolution {
    public static Population getNextGeneration(ParticipantInfo participantInfo) {
        int size = participantInfo.getStrategies().size();
        Population population = new Population(size);
        for (int i = 0; i < size / 2; i++) {
           population.addStrategy(StrategyFactory.findStrategyId(participantInfo.getStrategies().get(i)), 2);
        }
        Population failures = new Population(size);
        for (int i = size / 2; i < size; i++) {
            failures.addStrategy(StrategyFactory.findStrategyId(participantInfo.getStrategies().get(i)));
        }
        System.out.println("Failures: ");
        System.out.println(failures.toString());
        return population;
    }
}
