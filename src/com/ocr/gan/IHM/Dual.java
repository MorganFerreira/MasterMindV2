package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;
import com.ocr.gan.joueurs.Humain;
import com.ocr.gan.joueurs.Ordinateur;
import resources.Str;

import java.util.ArrayList;

public class Dual extends Jeu {

    Ordinateur ordinateur;
    Humain humain;


    public Dual(){
        humain = new Humain();
        ordinateur = new Ordinateur();
    }


    /**
     * Déroulement du dual
     */
    public void startGame(){

        //chall
        ArrayList<Integer> propositionSolution;
        ArrayList<String> clueC;
        // def
        ArrayList<String> clueH;

        // chall
        ArrayList<Integer> solutionC = ordinateur.initChallGenerationCombi();
        // def
        System.out.println(Str.secretCmb);
        ArrayList<Integer> solutionH = humain.initDefSaisieCombi();

        ArrayList<Integer> propositionIA = ordinateur.initDefGenerationCombi();

        boolean finH;
        boolean finC;

        if (Configuration.MODE_DEV()) {
            System.out.println(Str.modeDev + solutionC);
        }

        do {

            // chall
            System.out.println(Str.takeCmb);
            propositionSolution = humain.chalSaisieCombi();

            clueC = ordinateur.challGenerationIndice(propositionSolution, solutionC);
            if (clueC.contains("+") || clueC.contains("-")) {
                System.out.println(Str.clueIa + clueC);
            }

            finH = this.isOver(clueC);

            // def
            System.out.println(Str.reminderCmb + solutionH);

            System.out.println(Str.takeClue);
            clueH = humain.defSaisieIndice();
            propositionIA = ordinateur.defGenerationCombi(propositionIA, clueH);
            System.out.println(Str.propositionIa + propositionIA);
            finC = this.isOver(clueH);

        } while (!finH && !finC);

        if (finH) {
            System.out.println(Str.win);
            this.end();
        } else {
            System.out.println(Str.loose);
            this.end();
        }
    }

}
