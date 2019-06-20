package com.ocr.gan.moreless;

import org.apache.log4j.Logger;
import resources.Str;
import com.ocr.gan.Common.Utils;
import com.ocr.gan.config.Configuration;

import java.util.ArrayList;

public class Defender extends gameMode {

    ArrayList<Integer> combinationD = new ArrayList<>(Configuration.getNbrValues());
    ArrayList<Integer> solutionD = new ArrayList<>(Configuration.getNbrValues());
    ArrayList<String> clueD = new ArrayList<>();
    int nbrRoundD;
    Logger logger = Logger.getLogger(Defender.class);

    public Defender(){
        logger.info(Str.ruleDefender);

        takeCmb(combinationD);
        generateCmb(solutionD);
        //System.out.println("Proposition : " + solutionD.toString());
        logger.info("Proposition : " + solutionD.toString());
        //logger.info(Str.endOfRound, solutionD);
        nbrRoundD = 0;
    }

    public void play () {
        do {
            nbrRoundD += 1;
            Utils.isEqual = true;
            takeClue(clueD);

            for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                if (clueD.get(k).contains("+")) {
                    solutionD.set(k, solutionD.get(k) + 1);
                    Utils.isEqual = false;
                } else if (clueD.get(k).contains("-")) {
                    solutionD.set(k, solutionD.get(k) - 1);
                    Utils.isEqual = false;
                } else if (clueD.get(k).contains("=")) {
                    solutionD.set(k, solutionD.get(k) + 0);
                }
            }
            System.out.println("Proposition : " + solutionD.toString());
            clueD.clear();
        } while (!Utils.isEqual  && nbrRoundD < Configuration.getNbrRoundMax());

        Utils.end();
    }
}
