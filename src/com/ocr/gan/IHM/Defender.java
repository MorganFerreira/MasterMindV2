package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;
import com.ocr.gan.joueurs.Human;
import com.ocr.gan.joueurs.Computer;
import java.util.ArrayList;

public class Defender extends Game {

    Computer computer;
    Human human;
    private int nbrRound = 0;

    public Defender(){
        human = new Human();
        computer = new Computer();
    }

    public void startGame() {

        System.out.println(Str.ruleDefender);
        ArrayList<String> clueH = new ArrayList<>();
        ArrayList<Integer> firstProposal = new ArrayList<>();
        boolean fin;
        System.out.println(Str.secretCmb);
        ArrayList<Integer> solutionH = human.initSecretCombi();
        ArrayList<Integer> propositionIA = computer.generationCombi(firstProposal, clueH);
        System.out.println(Str.firstPropositionIa + propositionIA);

        do {
            System.out.println(Str.reminderCmb + solutionH);
            System.out.println(Str.takeClue);
            clueH = human.generationClue(null, null);
            propositionIA = computer.generationCombi(propositionIA, clueH);
            System.out.println(Str.propositionIa + propositionIA);
            nbrRound = this.roundLeft(clueH, nbrRound);
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
