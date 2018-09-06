package board;

import java.util.Random;

import actions.Action;

public class Board {

    private Reward[][] grid = new Reward[2][2];

    public Board(Reward cc, Reward cd, Reward dc, Reward dd) {
    	grid[Action.COOPERATE][Action.COOPERATE] = cc;
    	grid[Action.COOPERATE][Action.DEFECT] = cd;
    	grid[Action.DEFECT][Action.COOPERATE] = dc;
    	grid[Action.DEFECT][Action.DEFECT] = dd;
    }

    public Board(int cooperate, int betrayed, int betrayer, int defect) {
        grid[Action.COOPERATE][Action.COOPERATE] = new Reward(cooperate, cooperate);
        grid[Action.COOPERATE][Action.DEFECT] = new Reward(betrayed, betrayer);
        grid[Action.DEFECT][Action.COOPERATE] = new Reward(betrayer, betrayed);
        grid[Action.DEFECT][Action.DEFECT] = new Reward(defect, defect);
    }
    
    public Board() {
        this(new Random().nextInt(10), new Random().nextInt(10), new Random().nextInt(10), new Random().nextInt(10));
    }
    
    public Reward getReward(int aChoice, int bChoice) {
        return grid[aChoice][bChoice];
    }

    @Override
    public String toString() {
        String row0 = String.format("A coop     %s   |   %s   \n", grid[Action.COOPERATE][Action.COOPERATE].toString(), grid[Action.COOPERATE][Action.DEFECT].toString());
        String row1 = String.format("A def      %s   |   %s   \n", grid[Action.DEFECT][Action.COOPERATE].toString(), grid[Action.DEFECT][Action.DEFECT].toString());
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("(A, B)     B coop       B def    \n\n");
        sBuilder.append(row0);
        sBuilder.append("        ------------+------------\n");
        sBuilder.append(row1);
        sBuilder.append('\n');
        return sBuilder.toString();
    }

    public static void main(String[] args) {
        Board board = new Board(new Reward(2, 2), new Reward(0, 3), new Reward(3, 0), new Reward(1, 1));
        System.out.println(board.toString());
    }
}
