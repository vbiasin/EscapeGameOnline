package fr.openclassrooms.vb.util;

import fr.openclassrooms.vb.escapegameonline.Combination;
import org.apache.logging.log4j.LogManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {

    public Player() {
    }

    /**
     * This function must generate a new combination with user entries
     */
    public void setCombinationFromScanner() {
        Combination playerCombination = new Combination(Property.getLengthOfCombination());
        int position = 0;
        while (position < playerCombination.getCombinationLength()) {
            try {
                playerCombination.setCombinationNumberAtPosition(position, -1);
                while (playerCombination.checkCurrentNumber(position) == false) {
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Choose the " + position + 1 + " number of your combination !");
                    playerCombination.setCombinationNumberAtPosition(position, scan.nextInt());
                }
                position = position++;
            } catch (InputMismatchException e) {
                LogManager.getLogger(Player.class).error("You must enter an Integer !");
            } catch (Exception e) {
                LogManager.getLogger(Player.class).error("An error has occured !");
            }
        }
    }
}
