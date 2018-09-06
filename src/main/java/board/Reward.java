package board;

public class Reward {
	private final int a;
	private final int b;
	
	public Reward(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int getAReward() {
		return a;
	}
	
	public int getBReward() {
		return b;
	}

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }
}
