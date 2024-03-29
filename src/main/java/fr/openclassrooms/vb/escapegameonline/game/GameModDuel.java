package fr.openclassrooms.vb.escapegameonline.game;

import fr.openclassrooms.vb.escapegameonline.Combination;
import fr.openclassrooms.vb.escapegameonline.Computer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameModDuel extends GameMod{

    private static Logger log = LogManager.getLogger(GameModChallenger.class);

    public GameModDuel(boolean forceModRules) {
        super(forceModRules);
    }

    @Override
    public void runMod() {
        super.runMod();
        boolean continu = true;
        combinationComputerToFind = new Combination();
        Combination combinationPlayerToFind = new Combination();
        combinationPlayerToFind.setCombinationFromScanner();
        Computer computer = new Computer();
        computer.setComputerCombination(new Combination());
        while(continu){
            if(devMod){
                display.displayCombination(combinationComputer);
            }
            if(log.isDebugEnabled()){
                log.debug("The Combination of the computer is : " );
                display.displayCombination(combinationComputerToFind);
                log.debug("The Combination given by computer is : " );
                display.displayCombination(computer.getComputerCombination());
            }
            combinationPlayer.setCombinationFromScanner();
            combinationComputerToFind.compareCombination(combinationPlayer);
            display.displayCompartorOfCombination(combinationComputerToFind);
            display.displayCombination(computer.getComputerCombination());
            combinationPlayerToFind.setOperatorTabFromScanner();
            if(combinationComputerToFind.isTrue() && !combinationPlayerToFind.isTrue()){
                display.displayPlayerWin();
                continu=false;
            }
            if(combinationPlayerToFind.isTrue() && !combinationComputerToFind.isTrue()){
                display.displayComputerWin();
                continu=false;
            }
            if (combinationComputerToFind.isTrue() && combinationPlayerToFind.isTrue()){
                display.displayDraw();
                continu=false;
            }
            computer.resloveCombination(combinationPlayerToFind);
        }

    }
}
