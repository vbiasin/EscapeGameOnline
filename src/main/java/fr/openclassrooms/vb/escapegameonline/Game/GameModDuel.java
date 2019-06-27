package fr.openclassrooms.vb.escapegameonline.Game;

import fr.openclassrooms.vb.escapegameonline.Combination;
import fr.openclassrooms.vb.escapegameonline.Computer;
import fr.openclassrooms.vb.util.Property;
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
        Computer computer = new Computer();
        computer.setComputerCombination(new Combination());
        while(continu){
            if(devMod==true){
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
            combinationPlayer.setOperatorTabFromScanner();
            if(combinationComputerToFind.isTrue()){
                display.displayPlayerWin();
                continu=false;
            }
            if(combinationPlayer.isTrue()){
                display.displayComputerWin();
                continu=false;
            }
            if (combinationComputerToFind.isTrue() && combinationPlayer.isTrue()){
                display.displayDraw();
                continu=false;
            }
            computer.resloveCombination(combinationPlayer);
        }

    }
}
