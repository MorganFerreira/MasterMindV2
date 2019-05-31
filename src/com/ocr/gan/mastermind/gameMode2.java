package com.ocr.gan.mastermind;

import com.ocr.gan.config.Configuration;

import java.util.ArrayList;

import static com.ocr.gan.moreless.gameMode1.generateCmb;
import static com.ocr.gan.moreless.gameMode1.takeCmb;

public class gameMode2 {

    public static ArrayList<Integer> findGoodPlace ()
    {
        ArrayList<Integer> combination = new ArrayList<>(Configuration.getNbrValues());
        ArrayList<Integer> solution = new ArrayList<>(Configuration.getNbrValues());
        ArrayList<Integer> tmp = new ArrayList<>();

        final int goodPlace = -1;
        int ngp = 0;

        generateCmb(solution);
        takeCmb(combination);
        System.out.println("Proposition : " + combination.toString() + " --> Réponse : " + solution.toString());
        tmp.addAll(solution);

        for (int k = 0; k < Configuration.getNbrValues(); ++k)
        {
            if (tmp.get(k).equals(combination.get(k)))
            {
                ++ngp;
                tmp.set(k, goodPlace);
            }
        }
        System.out.println(tmp.toString());
        return tmp;
    }

    public static void afficherNgp () {
        ArrayList<Integer> tmp = findGoodPlace();
        for (int k = 0; k < Configuration.getNbrValues(); ++k){
            if (tmp.get(k).equals(-1)){
                System.out.println("#");
            }
        }

    }

    /*public static int transformationTmp () {
        ArrayList<Integer> tmp = findGoodPlace();
        for (int k = 0; k < Configuration.getNbrValues(); ++k){
            if (tmp.get(k) != -1 && tmp.get(k) )

        return tmp;
    }*/


}
