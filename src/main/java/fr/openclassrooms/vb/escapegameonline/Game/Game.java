package fr.openclassrooms.vb.escapegameonline.Game;

import fr.openclassrooms.vb.escapegameonline.Combination;
import fr.openclassrooms.vb.escapegameonline.Computer;
import fr.openclassrooms.vb.escapegameonline.Display;
import fr.openclassrooms.vb.util.Property;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {

    private Combination combinationComputer;
    private Combination combinationPlayer = new Combination();
    private Display display = new Display();
    private  int numberOfStrike = Property.getNumberOfStrikes();
    private static Logger log = LogManager.getLogger(Game.class);

    public Game() {
    }

    /**
     * Run the ChallengerMod
     */
    public void challengerMod(){
        combinationComputer = new Combination();
        while (numberOfStrike>0){
            if(log.isDebugEnabled()){
                log.debug("The number of strikes is : " + Property.getNumberOfStrikes());
                log.debug("The Combination is : " );
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

    /**
     * Run the defenderMod
     */
    public void defenderMod(){

        Computer computer = new Computer();
        computer.setComputerCombination(new Combination());
        combinationPlayer.setCombinationFromScanner();

        while (numberOfStrike>0){
            if(log.isDebugEnabled()){
                log.debug("The number of strikes is : " + Property.getNumberOfStrikes());
                log.debug("The Combination is : " );
                display.displayCombination(computer.getComputerCombination());
            }
            display.displayCombination(computer.getComputerCombination());
            combinationPlayer.setOperatorTabFromScanner();
            if(combinationPlayer.isTrue()){
                System.out.println("Computer WIN");
                numberOfStrike=-1;
            }
            numberOfStrike--;
            computer.resloveCombination(combinationPlayer);
        }
        if(numberOfStrike==0){
            System.out.println("Player WIN !");
            display.displayCombination(combinationPlayer);
        }
    }

    /**
     * Run the duelMod
     */
    public void duelMod(){

    }

    /**
     * player choose the game mod or exit the program.
     @return current MOD 1 for challenger, 2 for defender and 3 for versus
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
                scan.close();
                switch (choice) {
                    case 1:
                        current_mod=1;
                        if (log.isDebugEnabled()){
                            log.debug("You choose the challenger mod !" );
                        }
                        isChoiceValid = true;
                        break;
                    case 2:
                        current_mod=2;
                        if (log.isDebugEnabled()){
                            log.debug("You choose the defender mod !" );
                        }
                        isChoiceValid = true;
                        break;

                    case 3:
                        current_mod=3;
                        if (log.isDebugEnabled()){
                            log.debug("You choose the duel mod !" );
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
                log.error("You must enter 1 or 2 or 3 or 4 !" + e.getStackTrace());
            } catch (Exception e) {
                log.error("An error has occured !" + e.getStackTrace());
                System.out.println();
            }
        }
        return current_mod;
    }

    /**
     * Run mode in function of value given in parameter
     * return current MOD 1 for challenger, 2 for defender and 3 for versus
     * @param  value
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

    /**
     * Run application in function of value given by Scanner
     @param  current_mod
     @return always true
     */
    public boolean continueFromScanner(int current_mod){
        boolean isChoiceValid = false;
        boolean next = true;
        int choice = 0;
        display.displayEndGame();
        while(isChoiceValid==false){
            try {
                Scanner scan = new Scanner(System.in);
                choice = scan.nextInt();
                scan.close();
            }
            catch (InputMismatchException e) {
                log.error("You must enter 1 or 2 or 3 !" + e.getStackTrace());
            } catch (Exception e) {
                log.error("An error has occured !" + e.getStackTrace());
            }
            switch (choice) {
                case 1:
                    runGameFromValue(current_mod);
                    isChoiceValid = true;
                    break;

                case 2:
                    getModFromScanner();
                    isChoiceValid = true;
                    break;

                case 3:
                    next = false;
                    System.exit(0);
                    break;

                default:
                    System.out.println("You must enter 1 or 2 or 3 !");

            }
        }
        return next;
    }

}
