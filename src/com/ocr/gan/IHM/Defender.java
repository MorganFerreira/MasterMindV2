package com.ocr.gan.IHM;

import com.ocr.gan.Common.Utils;
import com.ocr.gan.config.Configuration;
import com.ocr.gan.joueurs.Humain;
import com.ocr.gan.joueurs.Ordinateur;
import resources.Str;

import java.util.ArrayList;

public class Defender extends Jeu {

    Ordinateur ordinateur;
    Humain humain;
    Utils utils;
    int nbrRound = 1;


    public Defender(){
        humain = new Humain();
        ordinateur = new Ordinateur();
        utils = new Utils();
    }


    // Déroulement du defender
    public void startGame() {

        ArrayList<String> clueH;
        boolean fin;

        ArrayList<Integer> solutionH = humain.initDefSaisieCombi();
        ArrayList<Integer> propositionIA = ordinateur.initDefGenerationCombi();

        do {
            System.out.println(Str.reminderCmb + solutionH);
            clueH = humain.defSaisieIndice();
            propositionIA = ordinateur.defGenerationCombi(propositionIA, clueH);
            System.out.println(Str.propositionIa + propositionIA);
            nbrRound = this.tourRestant(clueH, nbrRound);
            fin = this.isOver(clueH);
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
