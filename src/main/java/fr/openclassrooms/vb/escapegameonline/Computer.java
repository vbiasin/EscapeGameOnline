package fr.openclassrooms.vb.escapegameonline;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Computer {

    private int min = Constants.MIN;
    private int max = Constants.MIN;
    private Combination computerCombination;
    private static Logger log = LogManager.getLogger(Computer.class);

    public Computer() {

    }

    /**
     * Getters and Setters from usefull Attributs of Class
     */
    public Combination getComputerCombination() {
        return computerCombination;
    }

    public void setComputerCombination(Combination computerCombination) {
        this.computerCombination = computerCombination;
    }

    /**
     * This function must find the number of the current position
     * this function use the algorithm of dichotomie
     @param  playerCombination
     @param position
     */
    public void resolveNumberAtPosition(int position, Combination playerCombination){
        int oldValue = 0;
        int newValue = 0;
        log.debug("Current min " + this.min);
        log.debug("Current max " + this.max);

        try {
            oldValue = this.getComputerCombination().getValueAtposition(position);
        }
        catch(ArrayIndexOutOfBoundsException e ){
            LogManager.getLogger(Computer.class).error("Your position is not define !"+ e.getStackTrace());
        }

        if(Constants.PLUS.equals(playerCombination.getOperator()[position])){
            this.max=Constants.MAX;
            this.min=oldValue;
        }
        else{
            this.max=oldValue;
            this.min=Constants.MIN;
        }

        newValue = (this.min + this.max) / 2;

        if(Constants.EQUALS.equals(playerCombination.getOperator()[position])){
            newValue = oldValue;
        }

        try {
            this.getComputerCombination().setCombinationNumberAtPosition(position,newValue);
        }
        catch(ArrayIndexOutOfBoundsException e ){
            log.error("Your position is not define !"+ e.getStackTrace());
        }

        log.debug("Current operator " + playerCombination.getOperator()[position]);
        log.debug("Current min " + this.min);
        log.debug("Current max " + this.max);
        log.debug("Current oldValue " + oldValue);
        log.debug("Current newValue " + newValue);
    }

    /**
     * This function resolve the combination
     @param  playerCombination
     */
    public void resloveCombination(Combination playerCombination){
        for(int i=0; i<this.getComputerCombination().getCombinationLength(); i++){
            resolveNumberAtPosition(i,playerCombination);
        }
    }

}
