package com.ocr.gan.plusoumoins;

import com.ocr.gan.config.Configuration;
import org.apache.log4j.Logger;
import resources.Str;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Ordinateur {


    // solutionC --> combinaison à deviner
    ArrayList<Integer> solutionC;


    // propositionIa --> init combi def
    ArrayList<Integer> propositionIA;
    
    // clueH --> indice à remplir pour l'IA
    ArrayList<String> clueH;

    Logger logger = Logger.getLogger(Ordinateur.class);


    public Ordinateur() {}

    // CHALL init --> génération d'une combi à deviner
    public ArrayList<Integer> initChallGenerationCombi() {

        Random rnd = new Random();

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            solutionC.add(rnd.nextInt(Configuration.getNbrChoice()));
        } return solutionC;
    }

    // CHALL génération d'indice --> need combi humain
    public ArrayList<String> challGenerationIndice(ArrayList<Integer> propositionSolution) {

        ArrayList<String> clueC = new ArrayList<>();

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            if (propositionSolution.get(k) > solutionC.get(k)) {
                clueC.add(" - ");
            } else if (propositionSolution.get(k) < solutionC.get(k)) {
                clueC.add(" + ");
            } else {
                clueC.add(" = ");
            }
        }
        return clueC;
    }



    // DEF init --> génération d'une combi
    public void initDefGenerationCombi() {


        if (propositionIA.isEmpty()) {
            do {
                propositionIA.add(5);
            } while (propositionIA.size() < Configuration.getNbrValues());
        }
    }

    // DEF génération combi --> need indice et combi
    public void defGenerationCombi(){

        ArrayList<Integer> propositionIA = new ArrayList<Integer>();

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
