package com.ocr.gan.moreless;

import com.ocr.gan.Common.Utils;
import com.ocr.gan.config.Configuration;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Dual extends gameMode {

        ArrayList<Integer> combinationC = new ArrayList<>(Configuration.getNbrValues());
        ArrayList<Integer> solutionC = new ArrayList<>(Configuration.getNbrValues());
        ArrayList<String> clueC = new ArrayList<>();
        int nbrRoundC;

        ArrayList<Integer> combinationD = new ArrayList<>(Configuration.getNbrValues());
        ArrayList<Integer> solutionD = new ArrayList<>(Configuration.getNbrValues());
        ArrayList<String> clueD = new ArrayList<>();
        int nbrRoundD;

        Logger logger = Logger.getLogger(Dual.class);

    public Dual() {

        generateCmb(solutionC);
        nbrRoundC = 0;


        takeCmb(combinationD);
        generateCmb(solutionD);
        nbrRoundD = 0;
    }

    public void play() {

        Challenger challenger = new Challenger();
        Defender defender = new Defender();

        if (nbrRoundC > nbrRoundD) {
            defender.play();
        } else {
            challenger.play();
        }

    }
}