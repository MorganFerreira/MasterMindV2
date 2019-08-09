package com.ocr.gan.joueurs;

import com.ocr.gan.config.Configuration;
import resources.Str;

import java.util.Random;
import java.util.ArrayList;

public class Ordinateur {

    public Ordinateur() {
    }


    /**
     * CHALL init: génération de la combinaison à deviner
     *
     * @return solutionC --> La combinaison secrète de l'IA
     */
    public ArrayList<Integer> initChallGenerationCombi() {

        ArrayList<Integer> solutionC = new ArrayList<>();
        Random rnd = new Random();

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            solutionC.add(rnd.nextInt(Configuration.getNbrChoice()));
        }
        return solutionC;
    }

    /**
     * CHALL: génération d'indice de l'IA
     *
     * @param propositionSolution --> La proposition du joueur
     * @param solutionC --> La combinaison secrète de l'IA
     * @return clueC --> L'indice de l'IA
     */
    public ArrayList<String> challGenerationIndice(ArrayList<Integer> propositionSolution, ArrayList<Integer> solutionC) {

        ArrayList<String> clueC = new ArrayList<>();

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            if (propositionSolution.get(k) > solutionC.get(k)) {
                clueC.add("-");
            } else if (propositionSolution.get(k) < solutionC.get(k)) {
                clueC.add("+");
            } else {
                clueC.add("=");
            }
        }
        //logger.debug(cluec.toString)
        return clueC;
    }


    /**
     * DEF init: Génération de la première combinaison de l'IA
     *
     * @return propositionIA --> La proposition de l'IA
     */
    public ArrayList<Integer> initDefGenerationCombi() {

        ArrayList<Integer> propositionIA = new ArrayList<>();

        do {
            propositionIA.add(5);
        } while (propositionIA.size() < Configuration.getNbrValues());
        System.out.println(Str.firstPropositionIa + propositionIA);
        return propositionIA;
    }


    /**
     * DEF: génération de la combinaison de l'IA
     *
     * @param propositionIA --> La proposition de l'IA
     * @param clueH --> L'indice du joueur
     * @return propositionIA --> La proposition de l'IA
     */
    public ArrayList<Integer> defGenerationCombi(ArrayList<Integer> propositionIA, ArrayList<String> clueH) {

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            if (clueH.get(k).contains("+")) {
                propositionIA.set(k, ((Configuration.getNbrChoice() - propositionIA.get(k)) / 2) + propositionIA.get(k));
            } else if (clueH.get(k).contains("-")) {
                propositionIA.set(k, (propositionIA.get(k) - (propositionIA.get(k) / 2)));
            } else if (clueH.get(k).contains("=")) {
                propositionIA.set(k, propositionIA.get(k) + 0);
            }
        }
        return propositionIA;
    }
}
