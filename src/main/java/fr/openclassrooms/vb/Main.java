package fr.openclassrooms.vb;

import fr.openclassrooms.vb.escapegameonline.Game;
import fr.openclassrooms.vb.util.Property;
import org.apache.logging.log4j.LogManager;

public class Main {

    public static void main(String[] args) {

        try {
            Property.setDebug(("DEBUG".equals(args[0])));
        }
        catch (Exception e) {
            LogManager.getLogger(Main.class).error("An error has occured !" + e.getStackTrace());
            Property.setDebug(false);
        }

            Game game = new Game();
            int current_mod = game.getModFromScanner();
            game.runGameFromValue(current_mod);
    }
}

