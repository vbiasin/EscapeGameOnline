package fr.openclassrooms.vb.escapegameonline;

import fr.openclassrooms.vb.util.Property;
import org.apache.logging.log4j.LogManager;
import fr.openclassrooms.vb.util.RandomUtil;
import org.apache.logging.log4j.Logger;
import java.util.InputMismatchException;

public class Combination {

    private int combinationLength;
    private int combination [];
    private String operator [];
    private Display display = new Display();
    private static Logger log = LogManager.getLogger(Combination.class);

    public Combination() {
        combinationLength = Property.getLengthOfCombination();
        if(log.isDebugEnabled()) {
            log.debug("New Combination with length = " + this.combinationLength);
        }
        this.combination = RandomUtil.generateCombination(this.combinationLength);
        this.operator = new String [this.combinationLength];
    }

    /**
     * Getters and Setters from Attributs of Class
     */
    public int getCombinationLength() {
        return combinationLength;
    }

    public int[] getCombination() {
        return combination;
    }

    public void setCombination(int[] combination) {
        this.combination = combination;
    }

    public String[] getOperator() {
        return operator;
    }

    /**
     * This function must check value at current position
     * generate exception if position don't exist
     * Check if value at position is between 0 and 9 included
     @param position
     @return check
     */
    public boolean checkCurrentNumber(int position) throws ArrayIndexOutOfBoundsException {
        boolean check = true;
        if(this.getCombination()[position]<Constants.MIN || this.getCombination()[position]>Constants.MAX){
            check = false;
        }
        return check;
    }

    /**
     * This function return the value
     * generate exception if position don't exist
     @param  position
     @return value (int) at position
     */
    public int getValueAtposition(int position)throws  ArrayIndexOutOfBoundsException{
        return this.combination[position];
    }

    /**
     * This function put a value at the position check value at current position
     * generate exception if position don't exist
     @param  position
     @param value
     */
    public void setCombinationNumberAtPosition(int position, int value) throws  ArrayIndexOutOfBoundsException{
        this.combination[position] = value;
    }

    /**
     * This function put an operator at the position check value at current position
     * generate exception if position don't exist
     @param  position ;
     @param  value
     */
    public void setOperatorAtPosition(int position, String value) throws  ArrayIndexOutOfBoundsException{
        this.operator[position] = value;
    }

    /**
     * This function must generate a new combination with user entries
     */
    public void setCombinationFromScanner() {
        int position = 0;
        boolean stopScan=false;
        while (position < this.combinationLength) {
            try {
                if(log.isDebugEnabled()){
                    log.debug("Current position ! " + position);
                }
                this.setCombinationNumberAtPosition(position, -1);
                while ( stopScan == false) {
                    System.out.println("Choose the " + (position + 1) + " number of your combination !");
                    try{
                        this.setCombinationNumberAtPosition(position, Constants.SCAN.nextInt());
                        stopScan=this.checkCurrentNumber(position);
                        if(log.isDebugEnabled()){
                            log.debug("Value at Current position ! " + getCombination()[position]);
                           log.debug("Value of stopScan ! " + stopScan);
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e ){
                        log.error("Your position is not define !" + e.getStackTrace());
                    }
            }

            } catch (InputMismatchException e) {
                log.error("You must enter an Integer !");
            } catch (Exception e) {
                log.error("An error has occured !" + e.getStackTrace());
            }
            stopScan = false;
            position++;
            if (log.isDebugEnabled()){
                log.debug("Value of position ! " + position);
                log.debug("Value of stopScan ! " + stopScan);
            }
        }
    }

    /**
     * This function must check value at current position
     * generate exception if position don't exist
     * Check if value at position is correctly defined
     @param  position
     @return check
     */
    public boolean checkOperatorSymbolAtPosition(int position)  throws  ArrayIndexOutOfBoundsException{
        boolean check = false;
        if(Constants.EQUALS.equals(this.operator[position])
                || Constants.MINUS.equals(this.operator[position]) || Constants.PLUS.equals(this.operator[position])){
            check=true;
        }
        else{
            throw new IllegalArgumentException();
        }
        return check;
    }

    /**
     * with this fuction it's possible for the player to compare the computer combination with the own combination
     * and say to computer + if more, - if less = if the computer find the number at the position.
     */
    public void setOperatorTabFromScanner(){
        this.display.displayOperatorForCompare();
        int position = 0;
        boolean stopScan=false;
        while (position < this.combinationLength) {
            try {
                if(log.isDebugEnabled()){
                    log.debug("Current position ! " + position);
                }
                this.setOperatorAtPosition(position, null);
                while ( stopScan == false) {
                    System.out.println("Please give the operator of the " + (position + 1)
                            + " number of your combination!");
                    try{
                        this.setOperatorAtPosition(position, Constants.SCAN.next());
                        stopScan=this.checkOperatorSymbolAtPosition(position);
                        if(log.isDebugEnabled()){
                            log.debug("Value at Current position ! " + getCombination()[position]);
                            log.debug("Value of stopScan ! " + stopScan);
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e ){
                        log.error("Your position is not define !" + e.getStackTrace());
                    }
                }

            } catch (Exception e) {
                log.error("An error has occured !" + e.getStackTrace());
            }
            stopScan = false;
            position++;
            if (log.isDebugEnabled()){
                log.debug("Value of position ! " + position);
                log.debug("Value of stopScan ! " + stopScan);
            }
        }
    }

    /**
     * This function must compare two combinations
     * Compare each number from Computer Combination with combination given by user.
     * Show for each number if the user number is to big (-) or to small (+) or equal (=)
     * this function
     @param  combinationToCompare
     */
    public void compareCombination(Combination combinationToCompare){
        if(log.isDebugEnabled()){
            log.debug("The Combination to find is : " );
            display.displayCombination(combinationToCompare);
        }
        for (int i = 0; i < this.combinationLength; i++){
            if(this.combination[i] == combinationToCompare.getCombination()[i]){
                this.operator[i]= Constants.EQUALS;
            }
            else if (this.combination[i] < combinationToCompare.getCombination()[i]){
                this.operator[i]= Constants.MINUS;
            }
            else{
                this.operator[i]= Constants.PLUS;
            }
        }
    }

    /**
     * This function check if combination is true after compare
     * Compare each operator
     * return false if there is an operator which is different of =
     @return check
     */
    public boolean isTrue (){
        boolean check =true;
        for(int i=0; i<this.combinationLength; i++){
            if(this.getOperator()[i].equals(Constants.EQUALS)==false){
                check=false;
                break;
            }
        }
        return check;
    }

}