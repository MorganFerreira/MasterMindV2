package com.ocr.gan.plusoumoins;

import com.ocr.gan.config.Configuration;
import org.apache.log4j.Logger;
import java.util.Arrays;
import java.util.ArrayList;

import java.util.Scanner;
import resources.Str;

public class Humain {


    Scanner sc = new Scanner(System.in);
    Logger logger = Logger.getLogger(Humain.class);


    public Humain() {}

    // CHALL saisie d'une combi
    public ArrayList<Integer> chalSaisieCombi() {

        ArrayList<Integer> propositionSolution = new ArrayList<>();
        logger.info(Str.takeCmb);

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            propositionSolution.add(sc.nextInt());
        } return propositionSolution;

    }



    // DEF init --> saisie de combi à deviner
    public void initDefSaisieCombi() {

        ArrayList<Integer> solutionH = new ArrayList<>();

        logger.info(Str.takeCmb);
        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            solutionH.add(sc.nextInt());
        }
    }

    // DEF saisie de l'indice avec obligation d'une bonne saisie
    public void defSaisieIndice() {

        ArrayList<String> possibleClue = new ArrayList<>(Arrays.asList("+", "-", "="));
        ArrayList<String> clueH = new ArrayList<>();

        do {
            logger.info(Str.takeClue);
            for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                String tmp = sc.next();
                if (possibleClue.contains(tmp)) {
                    clueH.add(tmp);
                } else {
                    logger.info(Str.incorrectValues);
                    clueH.clear();
                    k = -1;
                }
            }
        } while (clueH.contains(possibleClue));
    }

}


