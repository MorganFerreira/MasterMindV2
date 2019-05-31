package com.ocr.gan.mastermind;

import com.ocr.gan.Common.Utils;
import com.ocr.gan.config.Configuration;

import java.util.ArrayList;

import static com.ocr.gan.moreless.gameMode1.generateCmb;
import static com.ocr.gan.moreless.gameMode1.takeCmb;

public class ChallengerMm extends gameMode2 {

    public static void Play() {

        ArrayList<Integer> combination = new ArrayList<>(Configuration.getNbrValues());
        ArrayList<Integer> solution = new ArrayList<>(Configuration.getNbrValues());


        int nbrRound = 0;

        do {
            nbrRound += 1;
            takeCmb(combination);
            Utils.isEqual = true;
            generateCmb(solution);



        } while (!Utils.isEqual && nbrRound < Configuration.getNbrRoundMax());
    }
}
