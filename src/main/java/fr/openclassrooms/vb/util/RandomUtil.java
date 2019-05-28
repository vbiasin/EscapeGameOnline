package fr.openclassrooms.vb.util;

public class RandomUtil {


    /**
     * this function return a random number between 0 and 9 both included
     * @return int number
     */
    public static int randomFigure(){
        int min = 0;
        int max = 9;
        int number = (int)(Math.random() * (max+1-min)) + min;
        return number;
    }

    /**
     * this function return a random combination
     */
    public static int [] generateCombination(int length){
        int combination[]= new int[length];
        for(int i=0; i<length; i++){
            combination[i] = randomFigure();
        }
        return combination;
    }
}
