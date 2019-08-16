package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;
import com.ocr.gan.joueurs.Humain;
import com.ocr.gan.joueurs.Ordinateur;
import java.util.ArrayList;

public class Dual extends Jeu {

    Ordinateur ordinateur;
    Humain humain;


    public Dual(){
        humain = new Humain();
        ordinateur = new Ordinateur();
    }

    public void startGame(){

        System.out.println(Str.ruleDual);
        //chall
        ArrayList<Integer> propositionSolution = new ArrayList<>();
        ArrayList<String> clueC;
        // def
        ArrayList<String> clueH = new ArrayList<>();
        ArrayList<Integer> firstProposal = new ArrayList<>();

        // chall
        ArrayList<Integer> solutionC = ordinateur.initSecretCombi();
        // def
        System.out.println(Str.secretCmb);
        ArrayList<Integer> solutionH = humain.initSecretCombi();

        ArrayList<Integer> propositionIA = ordinateur.generationCombi(firstProposal, clueH);
        System.out.println(Str.firstPropositionIa + propositionIA);

        boolean finH;
        boolean finC;

        if (Configuration.MODE_DEV()) {
            System.out.println(Str.modeDev + solutionC);
        }

        do {

            // chall
            System.out.println(Str.takeCmb);
            propositionSolution = humain.generationCombi(propositionSolution, null);

            clueC = ordinateur.generationClue(propositionSolution, solutionC);
            if (clueC.contains("+") || clueC.contains("-")) {
                System.out.println(Str.clueIa + clueC);
            }

            finH = this.isOver(clueC);

            // def
            System.out.println(Str.reminderCmb + solutionH);

            System.out.println(Str.takeClue);
            clueH = humain.generationClue(null, null);
            propositionIA = ordinateur.generationCombi(propositionIA, clueH);
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
