package fr.openclassrooms.vb.escapegameonline.Game;

import fr.openclassrooms.vb.escapegameonline.Combination;
import fr.openclassrooms.vb.escapegameonline.Computer;
import fr.openclassrooms.vb.util.Property;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameModDefender extends GameMod {

    private static Logger log = LogManager.getLogger(GameModChallenger.class);

    public GameModDefender(boolean forceModRules) {
        super(forceModRules);
    }

    @Override
    public void runMod() {
        super.runMod();
        Computer computer = new Computer();
        computer.setComputerCombination(new Combination());
        combinationPlayer.setCombinationFromScanner();

        while (numberOfStrike>0){
            if(log.isDebugEnabled()){
                log.debug("The number of strikes is : " + Property.getNumberOfStrikes());
                log.debug("The Combination is : " );
                display.displayCombination(computer.getComputerCombination());
            }
            if(devMod){
                display.displayCombination(combinationPlayer);
            }
            display.displayCombination(computer.getComputerCombination());
            combinationPlayer.setOperatorTabFromScanner();
            if(combinationPlayer.isTrue()){
                display.displayComputerWin();
                numberOfStrike=-1;
            }
            numberOfStrike--;
            computer.resloveCombination(combinationPlayer);
        }
        if(numberOfStrike==0){
            display.displayPlayerWin();
            display.displayCombination(combinationPlayer);
        }
    }
}
