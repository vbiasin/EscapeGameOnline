package fr.openclassrooms.vb.escapegameonline;


import fr.openclassrooms.vb.util.Property;
import org.apache.logging.log4j.LogManager;
import fr.openclassrooms.vb.util.RandomUtil;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Combination {



    private int combinationLength;
    private int combination [];
    private String operator [];
    private Display display = new Display();


    public Combination() {
        combinationLength = Property.getLengthOfCombination();

        if(Property.isDebug()==true) {
            LogManager.getLogger(Combination.class).debug("New Combination with length = " + this.combinationLength);
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
     @parm int position
     */
    public boolean checkCurrentNumber(int position) throws ArrayIndexOutOfBoundsException {
        boolean check = true;

        if(this.getCombination()[position]<0 || this.getCombination()[position]>9){
            check = false;
        }
        return check;

    }

    /**
     * This function put a value at the position check value at current position
     * generate exception if position don't exist
     @parm int position ; int value
     */
    public void setCombinationNumberAtPosition(int position, int value) throws  ArrayIndexOutOfBoundsException{
        this.combination[position] = value;
    }

    /**
     * This function must generate a new combination with user entries
     */
    public void setCombinationFromScanner() {
        int position = 0;
        boolean stopScan=false;
        while (position < this.combinationLength) {
            try {
                if(Property.isDebug()==true){
                    LogManager.getLogger(Combination.class).debug("Current position ! " + position);
                }
                this.setCombinationNumberAtPosition(position, -1);
                while ( stopScan == false) {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Choose the " + (position + 1) + " number of your combination !");
                    try{
                        this.setCombinationNumberAtPosition(position, scan.nextInt());
                        stopScan=this.checkCurrentNumber(position);
                        if(Property.isDebug()==true){
                            LogManager.getLogger(Combination.class).debug("Value at Current position ! " + getCombination()[position]);
                            LogManager.getLogger(Combination.class).debug("Value of stopScan ! " + stopScan);
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e ){
                        LogManager.getLogger(Combination.class).error("Your position is not define !"+ e.getStackTrace());
                    }
                }

            } catch (InputMismatchException e) {
                LogManager.getLogger(Combination.class).error("You must enter an Integer !");
            } catch (Exception e) {
                LogManager.getLogger(Combination.class).error("An error has occured !" + e.getStackTrace());
            }
            stopScan = false;
            position++;
            if (Property.isDebug()==true){
                LogManager.getLogger(Combination.class).debug("Value of position ! " + position);
                LogManager.getLogger(Combination.class).debug("Value of stopScan ! " + stopScan);
            }
        }

    }

    /**
     * This function must check value at current position
     * generate exception if position don't exist
     * Check if value at position is correctly defined
     @parm int position
     */
    public boolean checkOperatorSymbolAtPosition(int position)  throws  ArrayIndexOutOfBoundsException{
        boolean check = false;
        if(this.operator[position].equals("+") || this.operator[position].equals("-") || this.operator[position].equals("=")){
            check=true;
        }
        else{
            throw new IllegalArgumentException();
        }
        return check;
    }

    /**
     * This function must check all values of the operators tab
     */
    public boolean checkOperatorTab(){
        boolean check = false;
        for(int i = 0; i<this.combinationLength; i++){
            try {
                check = checkOperatorSymbolAtPosition(i);
            }
            catch(ArrayIndexOutOfBoundsException e ){
                LogManager.getLogger(Combination.class).error("Your position is not define !"+ e.getStackTrace());
            }
            catch (Exception e) {
                LogManager.getLogger(Combination.class).error("An error has occured !" + e.getStackTrace());
            }

        }
        return check;
    }

    //public void setOperatorTabFromScanner


    /**
     * This function must compare two combinations
     * Compare each number from Computer Combination with combination given by user.
     * Show for each number if the user number is to big (-) or to small (+) or equal (=)
     * this function
     @parm Combination combination
     */
    public void compareCombination(Combination combinationToCompare){
        if(Property.isDebug()==true){
            LogManager.getLogger(Combination.class).debug("The Combination to find is : " );
            display.displayCombination(combinationToCompare);
        }
        for (int i = 0; i < this.combinationLength; i++){
            if(this.combination[i] == combinationToCompare.getCombination()[i]){
                this.operator[i]= " = ";
            }
            else if (this.combination[i] < combinationToCompare.getCombination()[i]){
                this.operator[i]= " - ";
            }
            else{
                this.operator[i]= " + ";
            }
        }
    }

    /**
     * This function check if combination is true after compare
     * Compare each operator
     * Sreturn false if there is an operator which is different of =
     */
    public boolean isTrue (){
        boolean check =true;
        for(int i=0; i<this.combinationLength; i++){
            if(this.getOperator()[i].equals(" = ")==false){
                check=false;
                break;
            }
        }
        return check;
    }





}