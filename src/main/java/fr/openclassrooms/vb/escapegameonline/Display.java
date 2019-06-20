package fr.openclassrooms.vb.escapegameonline;

public class Display {

    public void writeInConsole(String text){
        System.out.println(text);
    }

    /**
     * Display all Play Mods avaible and exit option.
     */
    public  void displayPlayMod(){

        writeInConsole("1) Challenger (Find the combination chosen by the computer) ");
        writeInConsole("2) Defender (The computer will try to find the combination chosen by the you) ");
        writeInConsole("3) Duel (Find combination chosen by the computer before he finds yours) ");
        writeInConsole("4) Exit application");
        writeInConsole("Make your choice and press Enter to validate !");
    }

    /**
     * Display the tab of operators for the comparator of combination.
     */
    public void displayCompartorOfCombination(Combination combination){
        for(int i = 0; i<combination.getCombinationLength(); i++){
            writeInConsole(" "+combination.getOperator()[i]+" ");
        }
        writeInConsole("\n");
    }

    /**
     * Display combination.
     */
    public void displayCombination(Combination combination){
        for(int i = 0; i<combination.getCombinationLength(); i++){
            writeInConsole(String.valueOf(combination.getCombination()[i]));
        }
        writeInConsole("\n");
    }

    public void displayOperatorForCompare(){
        writeInConsole("Enter + if the computer give a number smaller than the number of your combination !");
        writeInConsole("Enter - if the computer give a number bigger than the number of your combination !");
        writeInConsole("Enter + if the computer give the same number than the number of your combination !");
    }

    /**
     * Display end choices.
     */
    public void displayEndGame(){
        writeInConsole("Enter 1) if you want to play again in the same mod !");
        writeInConsole("Enter 2) if you want to go back to game menu !");
        writeInConsole("Enter 3) if you want to exit the application!");
    }

    /**
     * Display Player WIN.
     */
    public void displayPlayerWin(){
        writeInConsole("PLAYER WIN !");
    }

    /**
     * Display Computer WIN.
     */
    public void displayComputerWin(){
        writeInConsole("COMPUTER WIN !");
    }

}
