package com.ocr.gan.plusoumoins;

import com.ocr.gan.config.Configuration;
import org.apache.log4j.Logger;
import resources.Str;

import java.util.ArrayList;
import java.util.Scanner;

public class Defender {

    // solutionH --> combinaison que l'IA doit deviner
    ArrayList<Integer> solutionH;
    // clueH --> indice à remplir pour l'IA
    ArrayList<String> clueH;
    // nbrRoundD --> nombre de round écoulé de la partie Defender
    public int nbrRoundD;
    Logger logger = Logger.getLogger(Defender.class);

    public Defender () {
        solutionH = new ArrayList<>();
        clueH = new ArrayList<>();
        nbrRoundD = 0;
        Scanner sc = new Scanner(System.in);

        logger.info(Str.takeCmb);
        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            solutionH.add(sc.nextInt());
        }
    }

    public ArrayList<Integer> JouerUnTour (ArrayList<String> clueH, ArrayList<Integer> propositionIA) {
        nbrRoundD++;

            for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                if (clueH.get(k).contains("+")) {
                    propositionIA.set(k, propositionIA.get(k) + 1);
                } else if (clueH.get(k).contains("-")) {
                    propositionIA.set(k, propositionIA.get(k) - 1);
                } else if (clueH.get(k).contains("=")) {
                    propositionIA.set(k, propositionIA.get(k) + 0);
                }
            //}
        } return propositionIA;
    }
}
