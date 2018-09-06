package strategy.random;

import java.util.Random;

import strategy.Strategy;

public abstract class RandomizedStrategy extends Strategy{
    protected int randomize(int choice, int probability) {
        return new Random().nextInt(100) < probability ? choice : (choice + 1) % 2;
    }
}
