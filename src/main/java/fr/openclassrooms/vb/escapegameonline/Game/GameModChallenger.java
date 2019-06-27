package fr.openclassrooms.vb.escapegameonline.Game;

import fr.openclassrooms.vb.escapegameonline.Combination;
import fr.openclassrooms.vb.util.Property;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameModChallenger extends GameMod {

    private static Logger log = LogManager.getLogger(GameModChallenger.class);

    public GameModChallenger(boolean forceModRules) {
        super(forceModRules);
    }

    @Override
    public void runMod() {
        super.runMod();
        combinationComputerToFind = new Combination();
        while (numberOfStrike>0){
            if(log.isDebugEnabled()){
                log.debug("The number of strikes is : " + Property.getNumberOfStrikes());
                log.debug("The Combination is : " );
                display.displayCombination(combinationComputerToFind);
            }
            if(devMod==true){
                display.displayCombination(combinationComputerToFind);
            }
            combinationPlayer.setCombinationFromScanner();
            combinationComputerToFind.compareCombination(combinationPlayer);
            display.displayCompartorOfCombination(combinationComputerToFind);
            if(combinationComputerToFind.isTrue()){
                display.displayPlayerWin();
                numberOfStrike=-1;
            }
            numberOfStrike--;
        }
        if(numberOfStrike==0){
            display.displayComputerWin();
            display.displayCombination(combinationComputerToFind);
        }
    }
}
