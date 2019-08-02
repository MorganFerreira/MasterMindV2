package com.ocr.gan.joueurs;

import com.ocr.gan.config.Configuration;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import resources.Str;

public class Humain {

    Scanner sc = new Scanner(System.in);

    public Humain() {}


    // CHALL saisie d'une combi
    public ArrayList<Integer> chalSaisieCombi() {

        ArrayList<Integer> propositionSolution = new ArrayList<>();
        System.out.println(Str.takeCmb);

        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            propositionSolution.add(sc.nextInt());
        } return propositionSolution;

    }



    // DEF init --> saisie de combi à deviner
    public ArrayList<Integer> initDefSaisieCombi() {

        ArrayList<Integer> solutionH = new ArrayList<>();

        System.out.println(Str.secretCmb);
        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            solutionH.add(sc.nextInt());
        } return solutionH;
    }

    // DEF saisie de l'indice avec obligation d'une bonne saisie
    public ArrayList<String> defSaisieIndice() {

        ArrayList<String> possibleClue = new ArrayList<>(Arrays.asList("+", "-", "="));
        ArrayList<String> clueH = new ArrayList<>();

        do {
            System.out.println(Str.takeClue);
            for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                String tmp = sc.next();
                if (possibleClue.contains(tmp)) {
                    clueH.add(tmp);
                } else {
                    System.out.println(Str.incorrectValues);
                    clueH.clear();
                    k = -1;
                }
            }
        } while (clueH.contains(possibleClue));
        return clueH;
    }

    /*        do {
            System.out.println(Str.takeClue);
            for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                String tmp = sc.next();
                if (possibleClue.contains(tmp)) {
                    clueH.add(tmp);
                } else {
                    System.out.println(Str.incorrectValues);
                    clueH.clear();
                    k = -1;
                }
            }
        } while (clueH.contains(possibleClue));*/
}


