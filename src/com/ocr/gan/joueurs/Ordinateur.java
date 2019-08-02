package com.ocr.gan.joueurs;

import com.ocr.gan.config.Configuration;
import resources.Str;

import java.util.Random;
import java.util.ArrayList;

public class Ordinateur {

    public Ordinateur() {}


    // CHALL init --> génération d'une combi à deviner
    public ArrayList<Integer> initChallGenerationCombi() {

        ArrayList<Integer> solutionC = new ArrayList<>();
        Random rnd = new Random();

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            solutionC.add(rnd.nextInt(Configuration.getNbrChoice()));
        } return solutionC;
    }

    // CHALL génération d'indice --> need combi humain
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
        System.out.println(Str.clueIa + clueC);
        return clueC;
    }



    // DEF init --> génération de la première combi
    public ArrayList<Integer> initDefGenerationCombi() {

        ArrayList<Integer> propositionIA = new ArrayList<>();

        do {
            propositionIA.add(5);
        } while (propositionIA.size() < Configuration.getNbrValues());
        System.out.println(Str.firstPropositionIa + propositionIA);
        return propositionIA;
    }


    // DEF génération combi --> need indice et combi
    public ArrayList<Integer> defGenerationCombi(ArrayList<Integer> propositionIA, ArrayList<String> clueH){

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            if (clueH.get(k).contains("+")) {
                propositionIA.set(k, propositionIA.get(k) + 1);
            } else if (clueH.get(k).contains("-")) {
                propositionIA.set(k, propositionIA.get(k) - 1);
            } else if (clueH.get(k).contains("=")) {
                propositionIA.set(k, propositionIA.get(k) + 0);
            }
        } return propositionIA;
    }
}
