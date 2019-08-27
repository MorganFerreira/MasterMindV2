package com.ocr.gan.joueurs;

import com.ocr.gan.config.Configuration;
import org.apache.log4j.Logger;
import java.util.Random;
import java.util.ArrayList;

public class Computer implements Player {

    Logger logger = Logger.getLogger(Computer.class);

    public Computer() {
    }

    @Override
    public ArrayList<Integer> initSecretCombi() {

        ArrayList<Integer> secretSolution = new ArrayList<>();
        Random rnd = new Random();

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            secretSolution.add(rnd.nextInt(Configuration.getNbrChoice()));
        }
        logger.debug("initSecretCombi - FIN - retour: " + secretSolution);
        return secretSolution;
    }

    @Override
    public ArrayList<Integer> generationCombi(ArrayList<Integer> propositionSolution, ArrayList<String> clue) {

        logger.debug("generationCombi - START - arguments: " + propositionSolution + ", " + clue);
        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            if (clue.isEmpty()) {
                propositionSolution.add(k, (Configuration.getNbrChoice()/2));
            } else if (clue.get(k).contains("-")) {
                if (propositionSolution.get(k) == 1) {
                    propositionSolution.set(k, 0);
                } else {
                    propositionSolution.set(k, (propositionSolution.get(k) - Math.round(propositionSolution.get(k) / 2)));
                }
            } else if (clue.get(k).contains("+")) {
                propositionSolution.set(k, (Math.floorDiv((Configuration.getNbrChoice() - propositionSolution.get(k)),2) + propositionSolution.get(k)));
            } else if (clue.get(k).contains("=")) {
                propositionSolution.set(k, propositionSolution.get(k) + 0);
            }
        }
        logger.debug("generationCombi - FIN - retour: " + propositionSolution);
        return propositionSolution;
    }

    @Override
    public ArrayList<String> generationClue(ArrayList<Integer> propositionSolution, ArrayList<Integer> secretSolution) {

        logger.debug("generationClue - START - arguments: " + propositionSolution + ", " + secretSolution);
        ArrayList<String> clue = new ArrayList<>();

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            if (propositionSolution.get(k) > secretSolution.get(k)) {
                clue.add("-");
            } else if (propositionSolution.get(k) < secretSolution.get(k)) {
                clue.add("+");
            } else {
                clue.add("=");
            }
        }
        logger.debug("generationClue - FIN - retour: " + clue);
        return clue;
    }
}
