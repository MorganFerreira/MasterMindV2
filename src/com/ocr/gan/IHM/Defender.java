package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;
import com.ocr.gan.joueurs.Humain;
import com.ocr.gan.joueurs.Ordinateur;
import java.util.ArrayList;

public class Defender extends Jeu {

    Ordinateur ordinateur;
    Humain humain;
    int nbrRound = 0;


    public Defender(){
        humain = new Humain();
        ordinateur = new Ordinateur();
    }

    public void startGame() {

        System.out.println(Str.ruleDefender);
        ArrayList<String> clueH = new ArrayList<>();
        ArrayList<Integer> firstProposal = new ArrayList<>();
        boolean fin;

        System.out.println(Str.secretCmb);
        ArrayList<Integer> solutionH = humain.initSecretCombi();

        ArrayList<Integer> propositionIA = ordinateur.generationCombi(firstProposal, clueH);
        System.out.println(Str.firstPropositionIa + propositionIA);

        do {
            System.out.println(Str.reminderCmb + solutionH);

            System.out.println(Str.takeClue);
            clueH = humain.generationClue(null, null);

            propositionIA = ordinateur.generationCombi(propositionIA, clueH);
            System.out.println(Str.propositionIa + propositionIA);
            nbrRound = this.tourRestant(clueH, nbrRound);
            fin = this.isOver(clueH);
        } while (!fin && Configuration.getNbrRoundMax() > nbrRound);

        if (!fin) {
            System.out.println(Str.win);
            this.end();
        } else {
            System.out.println(Str.loose);
            this.end();
        }
    }
}
