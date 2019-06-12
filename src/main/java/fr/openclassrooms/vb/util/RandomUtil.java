package fr.openclassrooms.vb.util;

import fr.openclassrooms.vb.escapegameonline.Constants;

public class RandomUtil {

    /**
     * this function return a random number between 0 and 9 both included
     * @return int number
     */
    public static int randomFigure(){
        int min = Constants.MIN;
        int max = Constants.MAX;
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
