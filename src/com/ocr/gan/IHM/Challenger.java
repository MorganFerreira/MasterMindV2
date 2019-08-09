package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;
import com.ocr.gan.joueurs.Humain;
import com.ocr.gan.joueurs.Ordinateur;
import resources.Str;

import java.util.ArrayList;

public class Challenger extends Jeu {

    Ordinateur ordinateur;
    Humain humain;

    private int nbrRound = 1;


    public Challenger(){
        humain = new Humain();
        ordinateur = new Ordinateur();
    }


    /**
     * Déroulement du challenger
     */
    public void startGame() {

        ArrayList<Integer> propositionSolution;
        ArrayList<String> clueC;
        boolean fin;

        ArrayList<Integer> solutionC = ordinateur.initChallGenerationCombi();

        if (Configuration.MODE_DEV()) {
            System.out.println(Str.modeDev + solutionC);
        }

        do {
            System.out.println(Str.takeCmb);
            propositionSolution = humain.chalSaisieCombi();

            clueC = ordinateur.challGenerationIndice(propositionSolution, solutionC);
            if (clueC.contains("+") || clueC.contains("-")) {
                System.out.println(Str.clueIa + clueC);
            }

            nbrRound = this.tourRestant(clueC, nbrRound);
            fin = this.isOver(clueC);
        } while (!fin && Configuration.getNbrRoundMax() != nbrRound);

        if (fin) {
            System.out.println(Str.win);
            this.end();
        } else {
            System.out.println(Str.loose);
            this.end();
        }
    }
}
