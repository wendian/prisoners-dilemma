package tournament;

import java.util.ArrayList;

import strategy.Strategy;

public class ParticipantInfo {
    private ArrayList<Matchup> matchups;
    private ArrayList<Strategy> strategies;
    
    public ParticipantInfo() {
        matchups = new ArrayList<>();
        strategies = new ArrayList<>();
    }

    public ArrayList<Matchup> getMatchups() {
        return matchups;
    }

    public void addMatchup(Matchup matchup) {
        matchups.add(matchup);
    }

    public ArrayList<Strategy> getStrategies() {
        return strategies;
    }

    public void addNewStrategy(Strategy strategy) {
        if (!strategies.contains(strategy)) {
            strategies.add(strategy);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Strategy strategy : strategies) {
            stringBuilder.append(strategy.getName() + ": " + strategy.getGlobalScore() + '\n');
        }
        return stringBuilder.toString();
    }
}
