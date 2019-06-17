package fr.openclassrooms.vb.escapegameonline.Game;

import fr.openclassrooms.vb.escapegameonline.Combination;
import fr.openclassrooms.vb.util.Property;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GameModChallenger extends GameMod {

    private static Logger log = LogManager.getLogger(GameModChallenger.class);

    public GameModChallenger() {
    }

    @Override
    public void runMod() {
        super.runMod();
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
}
