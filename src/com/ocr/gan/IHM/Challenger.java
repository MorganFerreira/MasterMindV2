package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;
import com.ocr.gan.joueurs.Human;
import com.ocr.gan.joueurs.Computer;
import java.util.ArrayList;

public class Challenger extends Game {

    Computer computer;
    Human human;
    private int nbrRound = 0;


    public Challenger(){
        human = new Human();
        computer = new Computer();
    }

    public void startGame() {

        System.out.println(Str.ruleChallenger);
        ArrayList<Integer> propositionSolution = new ArrayList<>();
        ArrayList<String> clueC;
        boolean fin;
        ArrayList<Integer> solutionC = computer.initSecretCombi();

        if (Configuration.MODE_DEV()) {
            System.out.println(Str.modeDev + solutionC);
        }

        do {
            System.out.println(Str.takeCmb);
            propositionSolution = human.generationCombi(propositionSolution,null);
            clueC = computer.generationClue(propositionSolution, solutionC);
            if (clueC.contains("+") || clueC.contains("-")) {
                System.out.println(Str.clueIa + clueC);
            }
            nbrRound = this.roundLeft(clueC, nbrRound);
            fin = this.isOver(clueC);
        } while (!fin && Configuration.getNbrRoundMax() > nbrRound);

        if (fin) {
            System.out.println(Str.win);
            this.end();
        } else {
            System.out.println(Str.loose);
            this.end();
        }
    }
}
