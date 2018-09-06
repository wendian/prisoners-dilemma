package strategy;

import strategy.complex.Grofman;
import strategy.complex.Nydegger;
import strategy.complex.TidemanChieruzzi;
import strategy.random.RandomAI;
import strategy.random.TitForTatRandom;
import strategy.random.TitForTwoTatsRandom;
import strategy.simple.AlwaysCooperate;
import strategy.simple.AlwaysDefect;
import strategy.simple.Grudger;
import strategy.simple.HumanInput;
import strategy.simple.Pavlov;
import strategy.simple.Prober;
import strategy.simple.SoftGrudger;
import strategy.simple.SuspiciousTitForTat;
import strategy.simple.Tester;
import strategy.simple.TitForTat;
import strategy.simple.TitForTwoTats;

public class StrategyFactory {
   
    public static final int TOTAL_STRATEGIES = 16;
    
    public static final int HUMAN = -1;

    public static final int RANDOM = 0;
    public static final int COOPERATE = 1;
    public static final int DEFECT = 2;
    public static final int TIT4TAT = 3;
    public static final int TIT4TATR = 4;
    public static final int TIT42TAT = 5;
    public static final int TIT42TATR = 6;
    public static final int GRUDGER = 7;
    public static final int STIT4TAT = 8;
    public static final int SOFTGRUDGER = 9;
    public static final int PROBER = 10;
    public static final int TESTER = 11;
    public static final int PAVLOV = 12;
    
    public static final int TIDEMAN_CHIERUZZ = 13;
    public static final int NYDEGGER = 14;
    public static final int GROFMAN = 15;

    
    public static Strategy getStrategy(int name) {
        switch (name) {
        case HUMAN:
            return new HumanInput();
        case COOPERATE:
            return new AlwaysCooperate();
        case DEFECT:
            return new AlwaysDefect();
        case TIT4TAT:
            return new TitForTat();
        case TIT4TATR:
            return new TitForTatRandom();
        case TIT42TAT:
            return new TitForTwoTats();
        case TIT42TATR:
            return new TitForTwoTatsRandom();
        case GRUDGER:
            return new Grudger();
        case STIT4TAT:
            return new SuspiciousTitForTat();
        case SOFTGRUDGER:
            return new SoftGrudger();
        case PROBER:
            return new Prober();
        case TESTER:
            return new Tester();
        case PAVLOV:
            return new Pavlov();
        case TIDEMAN_CHIERUZZ:
            return new TidemanChieruzzi();
        case NYDEGGER:
            return new Nydegger();
        case GROFMAN:
            return new Grofman();
        default:
            return new RandomAI();
        }
    }
    
    public static int findStrategyId(Strategy strategy) {
        for (int i = 0; i < TOTAL_STRATEGIES; i++) {
            if (getStrategy(i).getShortName().equals(strategy.getShortName())) {
                return i;
            }
        }
        return 0;
    }
    
    public static String idToString(int strategy) {
        return getStrategy(strategy).getName();
    }
}
