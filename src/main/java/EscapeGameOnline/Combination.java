package EscapeGameOnline;

import util.RandomUtil;


public class Combination {

    private int combinationLength; // will be define by parameter from xml file
    private int combination [];

    public Combination() {
        this.combinationLength=4;
        this.combination = RandomUtil.generateCombination(this.combinationLength);
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



}
