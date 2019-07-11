package com.ocr.gan.plusoumoins;

import com.ocr.gan.Common.Utils;
import com.ocr.gan.config.Configuration;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Random;

public class Challenger {
    // solutionC --> combinaison à deviner
    ArrayList<Integer> solutionC;
    // clueC --> indice donné par l'IA
    ArrayList<String> clueC;
    // nbrRoundC --> nombre de round écoulé de la partie Challenger
    public int nbrRoundC;
    Logger logger = Logger.getLogger(Challenger.class);

    public Challenger () {
        solutionC = new ArrayList<>();
        clueC = new ArrayList<>();
        nbrRoundC = 0;
        Random rnd = new Random();
        for (int k = 0; k < Configuration.getNbrValues() ; ++k) {
            solutionC.add(rnd.nextInt(Configuration.getNbrChoice()));
        }
    }

    public ArrayList<String> JouerUnTour (ArrayList<Integer> propositionSolution) {
        nbrRoundC++;
        logger.info(solutionC.toString());

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            if (propositionSolution.get(k) > solutionC.get(k)) {
                clueC.add(" - ");
            } else if (propositionSolution.get(k) < solutionC.get(k)) {
                clueC.add(" + ");
            } else {
                clueC.add(" = ");
            }
        } return clueC;
    }
}


