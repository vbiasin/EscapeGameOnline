package fr.openclassrooms.vb.escapegameonline.Game;

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
        if(devMod==true){
            display.displayCombination(combinationComputer);
        }
    }
}
