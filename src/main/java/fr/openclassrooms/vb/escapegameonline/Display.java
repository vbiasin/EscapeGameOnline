package fr.openclassrooms.vb.escapegameonline;

public class Display {



    /**
     * Display all Play Mods avaible and exit option.
     */
    public  void displayPlayMod(){

        System.out.println("1) Challenger (Find the combination chosen by the computer) ");
        System.out.println("2) Defender (The computer will try to find the combination chosen by the you) ");
        System.out.println("3) Duel (Find combination chosen by the computer before he finds yours) ");
        System.out.println("4) Exit application");
        System.out.println("Make your choice and press Enter to validate !");
    }

    /**
     * Display the tab of operators for the comparator of combination.
     */
    public void displayCompartorOfCombination(Combination combination){
        for(int i = 0; i<combination.getCombinationLength(); i++){
            System.out.print(combination.getOperator()[i]);
        }
        System.out.println();
    }

    /**
     * Display combination.
     */
    public void displayCombination(Combination combination){
        for(int i = 0; i<combination.getCombinationLength(); i++){
            System.out.print(combination.getCombination()[i]);
        }
        System.out.println();
    }




}
