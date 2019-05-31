package com.ocr.gan.moreless;

import resources.Str;
import com.ocr.gan.Common.Utils;
import com.ocr.gan.config.Configuration;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChallengerMl extends gameMode1 {

    ArrayList<Integer> combination = new ArrayList<>(Configuration.getNbrValues());
    ArrayList<Integer> solution = new ArrayList<>(Configuration.getNbrValues());
    ArrayList<String> clue = new ArrayList<>();
    int nbrRound;

    public ChallengerMl(){
        generateCmb(solution);
        nbrRound  = 0;
    }

    public void play() {

        Logger log = Logger.getLogger("");

        log.log(Level.INFO, Str.ruleChallenger);
        do {
            nbrRound += 1;
            takeCmb(combination);
            Utils.isEqual = true;

            for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                if (combination.get(k) > solution.get(k)) {
                    clue.add(" - ");
                    Utils.isEqual  =  false;
                } else if (combination.get(k) < solution.get(k)) {
                    clue.add(" + ");
                    Utils.isEqual = false;
                } else {
                    clue.add(" = ");
                }
            }
            //TODO Strings ???
            System.out.println("Proposition : " + combination.toString() + " --> Réponse : " + clue.toString());


            combination.clear();
            clue.clear();
        } while (!Utils.isEqual && nbrRound < Configuration.getNbrRoundMax());

        Utils.end();
    }
}
