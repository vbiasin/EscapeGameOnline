package fr.openclassrooms.vb;

import fr.openclassrooms.vb.escapegameonline.Game.Game;

public class Main {

    public static void main(String[] args) {

            Game game = new Game();
            boolean continu =true;
            int current_mod = game.getModFromScanner();
            game.runGameFromValue(current_mod);

            while (continu==true){
                continu=game.continueFromScanner(current_mod);
            }
    }
}

