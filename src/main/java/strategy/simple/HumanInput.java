package strategy.simple;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

import board.Board;
import strategy.Strategy;

public class HumanInput extends Strategy {

    private static int globalScore = 0;
    
    @Override
    public int makeChoice(Board board, ArrayList<Integer> ownHistory, ArrayList<Integer> opponentHistory) {
        System.out.println("Turn " + ownHistory.size());
        //System.out.println(board.toString());
        //System.out.println("Pick 0 or 1");
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (!(choice == 1 || choice == 0)) {
            try {
                choice = scanner.nextInt();
            } catch (NoSuchElementException e) {
                System.out.println("Must choose 0 or 1");
                choice = -1;
            }
        }
        return choice;
    }

    @Override
    public int getGlobalScore() {
        return globalScore;
    }

    @Override
    public void updateGlobalScore(int amount) {
        globalScore += amount;
    }

    @Override
    public String getName() {
        return "Human";
    }
    
    @Override
    public String getShortName() {
        return "HUMN";
    }
}
