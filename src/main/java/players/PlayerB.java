package players;

import board.Reward;
import strategy.Strategy;

public class PlayerB extends Player {

    public PlayerB(Strategy strategy) {
        super(strategy);
    }
    
    public PlayerB() {
        super();
    }
    
    @Override
    public void update(Reward reward) {
        getStrategy().updateGlobalScore(reward.getBReward());
        updateScore(reward.getBReward());
        getHistory().add(choice);
    }
}
