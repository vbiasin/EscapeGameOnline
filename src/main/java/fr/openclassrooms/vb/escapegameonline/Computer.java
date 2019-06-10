package fr.openclassrooms.vb.escapegameonline;


import fr.openclassrooms.vb.util.Property;
import org.apache.logging.log4j.LogManager;



public class Computer {

    private int min = Constants.MIN;
    private int max = Constants.MIN;
    private Combination computerCombination;

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
     @parm Combination combination, int position
     */
    public void resolveNumberAtPosition(int position, Combination playerCombination){
        int oldValue = 0;
        int newValue = 0;
        if(Property.isDebug()==true){
            LogManager.getLogger(Computer.class).debug("Current min " + this.min);
            LogManager.getLogger(Computer.class).debug("Current max " + this.max);
        }
        try {

            oldValue = this.getComputerCombination().getValueAtposition(position);
        }
        catch(ArrayIndexOutOfBoundsException e ){
            LogManager.getLogger(Computer.class).error("Your position is not define !"+ e.getStackTrace());
        }

        if(Constants.EQUALS.equals(playerCombination.getOperator()[position])){
            newValue = oldValue;
        }
        else if(Constants.PLUS.equals(playerCombination.getOperator()[position])){
            this.max=Constants.MAX;
            this.min=oldValue;
        }
        else{
            this.max=oldValue;
            this.min=Constants.MIN;
        }

        newValue = (this.min + this.max) / 2;

        try {
            this.getComputerCombination().setCombinationNumberAtPosition(position,newValue);
        }
        catch(ArrayIndexOutOfBoundsException e ){
            LogManager.getLogger(Computer.class).error("Your position is not define !"+ e.getStackTrace());
        }

        if(Property.isDebug()==true){
            LogManager.getLogger(Computer.class).debug("Current operator " + playerCombination.getOperator()[position]);
            LogManager.getLogger(Computer.class).debug("Current min " + this.min);
            LogManager.getLogger(Computer.class).debug("Current max " + this.max);
            LogManager.getLogger(Computer.class).debug("Current oldValue " + oldValue);
            LogManager.getLogger(Computer.class).debug("Current newValue " + newValue);
        }

    }



    /**
     * This function resolve the combination
     @parm Combination combination
     */
    public void resloveCombination(Combination playerCombination){
        for(int i=0; i<this.getComputerCombination().getCombinationLength(); i++){
            resolveNumberAtPosition(i,playerCombination);
        }

    }






}
