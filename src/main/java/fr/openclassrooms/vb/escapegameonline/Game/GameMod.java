package fr.openclassrooms.vb.escapegameonline.Game;

import fr.openclassrooms.vb.escapegameonline.Combination;
import fr.openclassrooms.vb.escapegameonline.Display;
import fr.openclassrooms.vb.util.Property;

public abstract class GameMod {

    protected Combination combinationComputer;
    protected Combination combinationComputerToFind;
    protected Combination combinationPlayer = new Combination();
    protected Display display = new Display();
    protected int numberOfStrike = Property.getNumberOfStrikes();
    protected boolean devMod ;

    public GameMod(boolean forceModRules) {
        devMod=Property.getDevMod();
        if(forceModRules==true){
            devMod=true;
        }
    }

    public void runMod(){



    }

}
