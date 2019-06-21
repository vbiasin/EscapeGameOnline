package fr.openclassrooms.vb;

import fr.openclassrooms.vb.escapegameonline.Constants;
import fr.openclassrooms.vb.escapegameonline.Game.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    public static void main(String[] args) {

        Logger log = LogManager.getLogger(Main.class);

        boolean forceModRules = false;
        if (args!=null && args.length>0 && "DEVMOD".equals(args[0])){
            forceModRules=true;
        }

        Game game = new Game(forceModRules);
        boolean continu =true;
        int current_mod = game.getModFromScanner();

        while (continu==true){
            continu=game.continueFromScanner(current_mod);
        }
        Constants.SCAN.close();
    }
}

