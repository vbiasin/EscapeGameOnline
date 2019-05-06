package fr.openclassrooms.vb.escapegameonline;

import fr.openclassrooms.vb.util.Property;
import org.apache.logging.log4j.LogManager;
import fr.openclassrooms.vb.util.RandomUtil;

import java.util.Properties;


public class Combination {



    private int combinationLength;
    private int combination [];
    private Properties properties;


    public Combination() {
        properties = Property.getInstance();
        combinationLength = Integer.parseInt(properties.getProperty("lengthOfCombination","4"));
        LogManager.getLogger(Combination.class).debug("New Combination with length = " + this.combinationLength);
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

    /**
     * This function must compare two combinations
     * Compare each number from Computer Combination with combination given by user.
     * Show for each number if the user number is to big (-) or to small (+) or equal (=)
     @parm Combination combination
     */
    public void compareCombination(Combination combination){

    }



}
