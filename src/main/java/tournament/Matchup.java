package tournament;

import strategy.Strategy;

public class Matchup {
    
    private Strategy playerAStrategy;
    private Strategy playerBStrategy;
    
    public Matchup(Strategy playerAStrategy, Strategy playerBStrategy) {
        this.playerAStrategy = playerAStrategy;
        this.playerBStrategy = playerBStrategy;
    }
    
    public Strategy getPlayerAStrategy() {
        return playerAStrategy;
    }
    
    public void setPlayerAStrategy(Strategy playerAStrategy) {
        this.playerAStrategy = playerAStrategy;
    }
    
    public Strategy getPlayerBStrategy() {
        return playerBStrategy;
    }
    
    public void setPlayerBStrategy(Strategy playerBStrategy) {
        this.playerBStrategy = playerBStrategy;
    }
}
