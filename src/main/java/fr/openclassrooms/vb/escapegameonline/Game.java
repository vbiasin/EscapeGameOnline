package fr.openclassrooms.vb.escapegameonline;

import fr.openclassrooms.vb.util.Property;
import org.apache.logging.log4j.LogManager;

import java.util.InputMismatchException;

import java.util.Scanner;

public class Game {

    private Combination combinationComputer;
    private Combination combinationPlayer = new Combination();
    private Display display = new Display();
    private  int numberOfStrike = Property.getNumberOfStrikes();


    public Game() {
    }

    /**
     * Run the ChallengerMod
     */
    public void challengerMod(){
        combinationComputer = new Combination();


        while (numberOfStrike>0){
            if(Property.isDebug()==true){
                LogManager.getLogger(Game.class).debug("The number of strikes is : " + Property.getNumberOfStrikes());
                LogManager.getLogger(Game.class).debug("The Combination is : " );
                display.displayCombination(combinationComputer);
            }
            combinationPlayer.setCombinationFromScanner();
            combinationComputer.compareCombination(combinationPlayer);
            display.displayCompartorOfCombination(combinationComputer);
            if(combinationComputer.isTrue()){
                System.out.println("Player WIN");
                numberOfStrike=-1;
            }
            numberOfStrike--;
        }

        if(numberOfStrike==0){
            System.out.println("Computer WIN !");
            display.displayCombination(combinationPlayer);
        }

    }

    public void defenderMod(){

        combinationPlayer.setCombinationFromScanner();

        while (numberOfStrike>0){
            if(Property.isDebug()==true){
                LogManager.getLogger(Game.class).debug("The number of strikes is : " + Property.getNumberOfStrikes());
                LogManager.getLogger(Game.class).debug("The Combination is : " );
                display.displayCombination(combinationPlayer);
            }
            combinationComputer=new Combination();
            combinationComputer.compareCombination(combinationPlayer);
            display.displayCompartorOfCombination(combinationComputer);
            if(combinationPlayer.isTrue()){
                System.out.println("Computer WIN");
                numberOfStrike=-1;
            }
            numberOfStrike--;
        }

        if(numberOfStrike==0){
            System.out.println("Player WIN !");
            display.displayCombination(combinationPlayer);
        }

    }

    public void duelMod(){

    }

    /**
     * player choose the game mod or exit the program.
     * return current MOD 1 for challenger, 2 for defender and 3 for versus
     */
    public int getModFromScanner(){
         boolean isChoiceValid = false;
         int current_mod = 0;
         int choice = 0;
        while (isChoiceValid == false) {
            display.displayPlayMod();
            try {
                Scanner scan = new Scanner(System.in);
                choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        current_mod=1;
                        if (Property.isDebug()==true){
                            LogManager.getLogger(Game.class).debug("You choose the challenger mod !" );
                        }
                        isChoiceValid = true;
                        break;
                    case 2:
                        current_mod=2;
                        if (Property.isDebug()==true){
                            LogManager.getLogger(Game.class).debug("You choose the defender mod !" );
                        }
                        isChoiceValid = true;
                        break;

                    case 3:
                        current_mod=3;
                        if (Property.isDebug()==true){
                            LogManager.getLogger(Game.class).debug("You choose the versus mod !" );
                        }
                        isChoiceValid = true;
                        break;

                    case 4:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("You must enter 1 or 2 or 3 or 4!");

                }
            } catch (InputMismatchException e) {
                LogManager.getLogger(Game.class).error("You must enter 1 or 2 or 3 or 4 !" + e.getStackTrace());
            } catch (Exception e) {
                LogManager.getLogger(Game.class).error("An error has occured !" + e.getStackTrace());
                System.out.println();
            }
        }
        return current_mod;
    }


    /**
     * Run mode in function of value given in parameter
     * return current MOD 1 for challenger, 2 for defender and 3 for versus
     * @ int value
     */
    public void runGameFromValue(int value){
        if (value == 1){
            challengerMod();
        }
        else if (value==2){
            defenderMod();
        }
        else {
            duelMod();
        }
    }





}
