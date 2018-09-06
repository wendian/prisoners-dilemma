package players;

import board.Reward;
import strategy.Strategy;

public class PlayerA extends Player {

    public PlayerA(Strategy strategy) {
        super(strategy);
    }
    
    public PlayerA() {
        super();
    }

    @Override
    public void update(Reward reward) {
        getStrategy().updateGlobalScore(reward.getAReward());
        updateScore(reward.getAReward());
        getHistory().add(choice);
    }
}
