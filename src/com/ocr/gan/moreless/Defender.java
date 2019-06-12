package com.ocr.gan.moreless;

import resources.Str;
import com.ocr.gan.Common.Utils;
import com.ocr.gan.config.Configuration;

import java.util.ArrayList;

public class DefenderMl extends gameMode1 {

    public static void play() {

        ArrayList<Integer> combination = new ArrayList<>(Configuration.getNbrValues());
        ArrayList<Integer> solution = new ArrayList<>(Configuration.getNbrValues());
        ArrayList<String> clue = new ArrayList<>();
        int nbrRound = 0;

        System.out.println(Str.ruleDefender);
        takeCmb(combination);
        generateCmb(solution);
        System.out.println("Proposition : " + solution.toString());

        do {
            nbrRound += 1;
            Utils.isEqual = true;
            takeClue(clue);

            for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                if (clue.get(k).contains("+")) {
                    solution.set(k, solution.get(k) + 1);
                    Utils.isEqual = false;
                } else if (clue.get(k).contains("-")) {
                    solution.set(k, solution.get(k) - 1);
                    Utils.isEqual = false;
                } else if (clue.get(k).contains("=")) {//TODO = ne fixe pas la valeure
                    solution.set(k, k);
                }
            }

            System.out.println("Proposition : " + solution.toString());
            clue.clear();
        } while (!Utils.isEqual  && nbrRound < Configuration.getNbrRoundMax());

        Utils.end();
    }
}
