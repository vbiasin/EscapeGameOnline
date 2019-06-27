package fr.openclassrooms.vb.escapegameonline.Game;

import fr.openclassrooms.vb.escapegameonline.Constants;
import fr.openclassrooms.vb.escapegameonline.Display;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.InputMismatchException;

public class Game {

    private  Display display;
    private GameModChallenger challenger;
    private GameModDefender defender;
    private GameModDuel duel;
    private static Logger log = LogManager.getLogger(Game.class);

    public Game(boolean forceModRules) {
        duel = new GameModDuel(forceModRules);
        defender = new GameModDefender(forceModRules);
        challenger = new GameModChallenger(forceModRules);
        display = new Display();
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
                choice = Constants.SCAN.nextInt();
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
                        display.displayDefault1To4();

                }
            } catch (InputMismatchException e) {
                log.error("You must enter 1 or 2 or 3 or 4 !" + e.getStackTrace());
            } catch (Exception e) {
                log.error("An error has occured !" + e.getStackTrace());
                System.out.println();
            }
        }
        runGameFromValue(current_mod);
        return current_mod;
    }

    /**
     * Run mode in function of value given in parameter
     * return current MOD 1 for challenger, 2 for defender and 3 for versus
     * @param  value
     */
    public void runGameFromValue(int value){
        if (value == 1){
            challenger.runMod();
        }
        else if (value==2){
            defender.runMod();
        }
        else {
            duel.runMod();
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
                choice = Constants.SCAN.nextInt();
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
                    display.displayDefault1To3();

            }
        }
        return next;
    }

}
