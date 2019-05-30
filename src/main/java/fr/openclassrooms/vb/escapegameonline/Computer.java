package fr.openclassrooms.vb.escapegameonline;


public class Computer {

    private int middle;
    private int min;
    private int max;

    public Computer(Combination combination) {
        this.min = 0;
        this.max = combination.getCombinationLength() ;
        this.middle = (min+max)/2;
    }

    /**
     * Getters and Setters from Attributs of Class
     */
    public int getMiddle() {
        return middle;
    }

    public void setMiddle(int middle) {
        this.middle = middle;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }


}
