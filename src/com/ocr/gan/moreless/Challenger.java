package com.ocr.gan.moreless;

import resources.Str;
import com.ocr.gan.Common.Utils;
import com.ocr.gan.config.Configuration;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Challenger extends gameMode {

    ArrayList<Integer> combinationC = new ArrayList<>(Configuration.getNbrValues());
    ArrayList<Integer> solutionC = new ArrayList<>(Configuration.getNbrValues());
    ArrayList<String> clueC = new ArrayList<>();
    int nbrRoundC;

    public Challenger(){
        Logger log = Logger.getLogger("");
        if (Configuration.MODE_DEV()) {
            generateCmb(solutionC);
            log.log(Level.INFO, Str.modeDev);
            System.out.println(solutionC.toString());
        } else {
            generateCmb(solutionC);
        }
        nbrRoundC = 0;
    }

    public void play() {

        Logger log = Logger.getLogger("");

        log.log(Level.INFO, Str.ruleChallenger);
        do {
            nbrRoundC += 1;
            takeCmb(combinationC);
            Utils.isEqual = true;

            for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                if (combinationC.get(k) > solutionC.get(k)) {
                    clueC.add(" - ");
                    Utils.isEqual  =  false;
                } else if (combinationC.get(k) < solutionC.get(k)) {
                    clueC.add(" + ");
                    Utils.isEqual = false;
                } else {
                    clueC.add(" = ");
                }
            }
            System.out.println("Proposition : " + combinationC.toString() + " --> Réponse : " + clueC.toString());


            combinationC.clear();
            clueC.clear();
        } while (!Utils.isEqual && nbrRoundC < Configuration.getNbrRoundMax());

        Utils.end();
    }
}
