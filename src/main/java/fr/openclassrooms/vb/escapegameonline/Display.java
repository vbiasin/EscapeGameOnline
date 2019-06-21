package fr.openclassrooms.vb.escapegameonline;

public class Display {

    public void writeInConsoleln(String text){
        System.out.println(text);
    }

    public void writeInConsole(String text){

        System.out.print(text);
    }

    /**
     * Display all Play Mods avaible and exit option.
     */
    public  void displayPlayMod(){

        writeInConsoleln("1) Challenger (Find the combination chosen by the computer) ");
        writeInConsoleln("2) Defender (The computer will try to find the combination chosen by the you) ");
        writeInConsoleln("3) Duel (Find combination chosen by the computer before he finds yours) ");
        writeInConsoleln("4) Exit application");
        writeInConsoleln("Make your choice and press Enter to validate !");
    }

    /**
     * Display the tab of operators for the comparator of combination.
     */
    public void displayCompartorOfCombination(Combination combination){
        for(int i = 0; i<combination.getCombinationLength(); i++){
            writeInConsole(" "+combination.getOperator()[i]+" ");
        }
        writeInConsoleln("\n");
    }

    /**
     * Display combination.
     */
    public void displayCombination(Combination combination){
        for(int i = 0; i<combination.getCombinationLength(); i++){
            writeInConsole(String.valueOf(combination.getCombination()[i]));
        }
        writeInConsoleln("\n");
    }

    public void displayOperatorForCompare(){
        writeInConsoleln("Enter + if the computer give a number smaller than the number of your combination !");
        writeInConsoleln("Enter - if the computer give a number bigger than the number of your combination !");
        writeInConsoleln("Enter + if the computer give the same number than the number of your combination !");
    }

    /**
     * Display end choices.
     */
    public void displayEndGame(){
        writeInConsoleln("Enter 1) if you want to play again in the same mod !");
        writeInConsoleln("Enter 2) if you want to go back to game menu !");
        writeInConsoleln("Enter 3) if you want to exit the application!");
    }

    /**
     * Display Player WIN.
     */
    public void displayPlayerWin(){
        writeInConsoleln("PLAYER WIN !");
    }

    /**
     * Display Computer WIN.
     */
    public void displayComputerWin(){
        writeInConsoleln("COMPUTER WIN !");
    }

    /**
     * Display give Number at a position
     */
    public void displayGiveNumber(int position){
        writeInConsole("Choose the " + (position + 1) + " number of your combination !");
    }

    /**
     * Display give Number at a position
     */
    public void displayGiveOperator(int position){
        writeInConsole("Please give the operator of the " + (position + 1) + " number of your combination!");
    }

    public void displayDefault1To3(){
        writeInConsole("You must enter 1 or 2 or 3 !");
    }

    public void displayDefault1To4(){
        writeInConsole("You must enter 1 or 2 or 3 or 4!");
    }

}
