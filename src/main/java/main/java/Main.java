package main.java;

import EscapeGameOnline.Combination;

public class Main {

    public static void main(String[] args) {

        Combination test = new Combination();
        for(int i=0; i<test.getCombinationLength(); i++){
            System.out.println(test.getCombination()[i]);
        }


    }
}
