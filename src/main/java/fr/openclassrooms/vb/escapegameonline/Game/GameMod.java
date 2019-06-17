package fr.openclassrooms.vb.escapegameonline.Game;

import fr.openclassrooms.vb.escapegameonline.Combination;
import fr.openclassrooms.vb.escapegameonline.Display;
import fr.openclassrooms.vb.util.Property;

public abstract class GameMod {

    protected Combination combinationComputer;
    protected Combination combinationPlayer = new Combination();
    protected Display display = new Display();
    protected   int numberOfStrike = Property.getNumberOfStrikes();

    public void runMod(){

    }

}
