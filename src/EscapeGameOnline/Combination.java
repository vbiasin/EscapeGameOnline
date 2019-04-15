package EscapeGameOnline;

public class Combination {

    private int combinationLength;
    private int combination [];

    public Combination() {
        this.combinationLength=4;

    }

    /**
     * Getters and Setters
     */
    public int getCombinationLength() {
        return combinationLength;
    }

    public void setCombinationLength(int combinationLength) {
        this.combinationLength = combinationLength;
    }

    public int[] getCombination() {
        return combination;
    }

    public void setCombination(int[] combination) {
        this.combination = combination;
    }

    /**
     * this function return a random number between 0 and 9 both included
     * int number = (int)(Math.random() * (max+1-min)) + min;
     * @return int
     */
     public int randomFigure(){
         return -1;
     }
}
