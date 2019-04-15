package EscapeGameOnline;

public class Combination {

    private int combinationLength; // will be define by parameter from xml file
    private int combination [];

    public Combination() {
        this.combinationLength=4;
        this.combination = new int[this.combinationLength];
        for(int i=0; i<this.combinationLength; i++){
            this.combination[i] = randomFigure();
        }

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
     * @return int number
     */
     public int randomFigure(){
         int min = 0;
         int max = 9;
         int number = (int)(Math.random() * (max+1-min)) + min;
         return number;
     }
}
