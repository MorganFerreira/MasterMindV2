package com.ocr.gan.joueurs;

import com.ocr.gan.config.Configuration;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.ocr.gan.IHM.Str;
import org.apache.log4j.Logger;

public class Human implements Player {

    Scanner sc = new Scanner(System.in);
    Logger logger = Logger.getLogger(Human.class);

    public Human() {
    }

    @Override
    public ArrayList<Integer> initSecretCombi() {

        boolean answerIsGood;
        ArrayList<Integer> secretSolution = new ArrayList<>();

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            do {
                try {
                    secretSolution.add(sc.nextInt());
                    answerIsGood = true;
                } catch (InputMismatchException e) {
                    System.out.println(Str.incorrectValues);
                    sc.next();
                    answerIsGood = false;
                }
            } while (!answerIsGood);
        }
        logger.debug("initSecretCombi - FIN - retour: " + secretSolution);
        return secretSolution;
    }

    @Override
    public ArrayList<Integer> generationCombi(ArrayList<Integer> propositionSolution, ArrayList<String> clue) {

        boolean answerIsGood;
        propositionSolution.clear();

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            do {
                try {
                    propositionSolution.add(sc.nextInt());
                    answerIsGood = true;
                } catch (InputMismatchException e) {
                    System.out.println(Str.incorrectValues);
                    sc.next();
                    answerIsGood = false;
                }
            } while (!answerIsGood);
        }
        logger.debug("generationCombi - FIN - retour: " + propositionSolution);
        return propositionSolution;
    }

    @Override
    public ArrayList<String> generationClue(ArrayList<Integer> propositionSolution, ArrayList<Integer> secretSolution) {

        ArrayList<String> possibleClue = new ArrayList<>(Arrays.asList("+", "-", "="));
        ArrayList<String> clue = new ArrayList<>();

        do {
            for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                String tmp = sc.next();
                if (possibleClue.contains(tmp)) {
                    clue.add(tmp);
                } else {
                    System.out.println(Str.incorrectValues);
                    clue.clear();
                    k = -1;
                }
            }
        } while (clue.contains(possibleClue));
        logger.debug("generationClue - FIN - retour: " + clue);
        return clue;
    }
}


