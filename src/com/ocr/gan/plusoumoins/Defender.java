package com.ocr.gan.plusoumoins;

import com.ocr.gan.Common.Utils;
import com.ocr.gan.config.Configuration;
import org.apache.log4j.Logger;
import resources.Str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Defender {

    // solutionH --> combinaison que l'IA doit deviner
    ArrayList<Integer> solutionH;
    // propositionIA --> proposition de solution de l'IA
    ArrayList<Integer> propositionIA;
    // clueH --> indice à remplir pour l'IA
    ArrayList<String> clueH;
    // nbrRoundD --> nombre de round écoulé de la partie Defender
    public int nbrRoundD;
    Logger logger = Logger.getLogger(Defender.class);

    public Defender () {
        solutionH = new ArrayList<Integer>();
        propositionIA = new ArrayList<Integer>(Configuration.getNbrValues());
        clueH = new ArrayList<String>();
        nbrRoundD = 0;
        Scanner sc = new Scanner(System.in);

        logger.info(Str.takeCmb);
        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            solutionH.add(sc.nextInt());
        }
    }

    public ArrayList<Integer> JouerUnTour (ArrayList<String> clueH) {
        nbrRoundD++;

        if (propositionIA.isEmpty()) {
            do {
                propositionIA.add(5);
            } while (propositionIA.size() < Configuration.getNbrValues());
        } else {
            for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                if (clueH.get(k).contains("+")) {
                    propositionIA.set(k, propositionIA.get(k) + 1);
                } else if (clueH.get(k).contains("-")) {
                    propositionIA.set(k, propositionIA.get(k) - 1);
                    Utils.isEqual = false;
                } else if (clueH.get(k).contains("=")) {
                    propositionIA.set(k, propositionIA.get(k) + 0);
                }
            }
        } return propositionIA;
    }
}
