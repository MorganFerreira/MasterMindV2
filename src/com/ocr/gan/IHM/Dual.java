package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;
import com.ocr.gan.joueurs.Human;
import com.ocr.gan.joueurs.Computer;
import java.util.ArrayList;

public class Dual extends Game {

    Computer computer;
    Human human;

    public Dual(){
        human = new Human();
        computer = new Computer();
    }

    public void startGame(){

        System.out.println(Str.ruleDual);
        //chall
        ArrayList<Integer> propositionSolution = new ArrayList<>();
        ArrayList<String> clueC;
        ArrayList<Integer> solutionC = computer.initSecretCombi();
        boolean finH;
        // def
        ArrayList<String> clueH = new ArrayList<>();
        ArrayList<Integer> firstProposal = new ArrayList<>();
        System.out.println(Str.secretCmb);
        ArrayList<Integer> solutionH = human.initSecretCombi();
        ArrayList<Integer> propositionIA = computer.generationCombi(firstProposal, clueH);
        System.out.println(Str.firstPropositionIa + propositionIA);
        boolean finC;

        if (Configuration.MODE_DEV()) {
            System.out.println(Str.modeDev + solutionC);
        }

        do {

            // chall
            System.out.println(Str.takeCmbDual);
            propositionSolution = human.generationCombi(propositionSolution, null);
            clueC = computer.generationClue(propositionSolution, solutionC);
            if (clueC.contains("+") || clueC.contains("-")) {
                System.out.println(Str.clueIa + clueC);
            }
            finH = this.isOver(clueC);

            // def
            System.out.println(Str.reminderCmb + solutionH);

            System.out.println(Str.takeClue);
            clueH = human.generationClue(null, null);
            propositionIA = computer.generationCombi(propositionIA, clueH);
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