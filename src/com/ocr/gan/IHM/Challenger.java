package com.ocr.gan.IHM;

import com.ocr.gan.Common.Utils;
import com.ocr.gan.config.Configuration;
import com.ocr.gan.joueurs.Humain;
import com.ocr.gan.joueurs.Ordinateur;
import resources.Str;

import java.util.ArrayList;

public class Challenger extends Jeu {

    Ordinateur ordinateur;
    Humain humain;
    Utils utils;

    private int nbrRound = 1;


    public Challenger(){
        humain = new Humain();
        ordinateur = new Ordinateur();
        utils = new Utils();
    }


    // Déroulement du challenger
    public void startGame(){

        ArrayList<Integer> propositionSolution;
        ArrayList<String> clueC;
        boolean fin;

        ArrayList<Integer> solutionC = ordinateur.initChallGenerationCombi();

        do {
            System.out.println(solutionC);
            propositionSolution = humain.chalSaisieCombi();
            clueC = ordinateur.challGenerationIndice(propositionSolution, solutionC);
            nbrRound = this.tourRestant(clueC, nbrRound);
            fin = this.isOver(clueC);
        } while (!fin && Configuration.getNbrRoundMax() == nbrRound);

        if (fin) {
            System.out.println(Str.win);
            this.end();
        } else {
            System.out.println(Str.loose);
            this.end();
        }
    }
}
