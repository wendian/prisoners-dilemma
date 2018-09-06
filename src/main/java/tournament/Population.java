package tournament;

import java.util.HashMap;
import java.util.Map.Entry;

import strategy.StrategyFactory;

public class Population {
    private final int maxPopulation;
    
    private int currentPopulation;

    private HashMap<Integer, Integer> strategies;
    
    public Population(int maxPopulation) {
        this.maxPopulation = maxPopulation;
        currentPopulation = 0;
        strategies = new HashMap<>();
    }

    public HashMap<Integer, Integer> getStrategies() {
        return strategies;
    }

    public void addStrategy(int strategy) {
        if (currentPopulation == maxPopulation) {
            throw new IndexOutOfBoundsException("Attempted to add too many strategies to the population");
        }
        if (!strategies.containsKey(strategy)) {
            strategies.put(strategy, 1);
        } else {
            strategies.put(strategy, strategies.get(strategy) + 1);
        }
        currentPopulation++;
    }
    
    public void addStrategy(int strategy, int count) {
        if (count < 1 || currentPopulation == maxPopulation) {
            throw new IndexOutOfBoundsException("Attempted to add too many strategies to the population");
        }
        if (!strategies.containsKey(strategy)) {
            strategies.put(strategy, count);
        } else {
            strategies.put(strategy, strategies.get(strategy) + count);
        }
        currentPopulation += count;
    }
    
    public int getMaxPopulation() {
        return maxPopulation;
    }
    
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry<Integer, Integer> entry : strategies.entrySet()) {
            stringBuilder.append(StrategyFactory.idToString(entry.getKey()) + ": " + entry.getValue() + '\n');
        }
        return stringBuilder.toString();
    }
}
