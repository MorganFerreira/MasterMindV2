package com.ocr.gan.IHM;

import com.ocr.gan.Common.Utils;
import com.ocr.gan.config.Configuration;
import com.ocr.gan.plusoumoins.Challenger;
import org.apache.log4j.Logger;
import resources.Str;

import java.util.ArrayList;
import java.util.Scanner;

public class ChallengerIhm {
    Challenger chal;
    Scanner sc = new Scanner(System.in);
    Logger logger = Logger.getLogger(ChallengerIhm.class);

    public ChallengerIhm(){
        chal = new Challenger();
    }

    public void Affichage(){

        ArrayList<Integer> propositionSolution = new ArrayList<Integer>();
        ArrayList<String> clueC = new ArrayList<String>();
        Boolean fin = false;

        do {
            System.out.println(Str.takeCmb);
            for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                propositionSolution.add(sc.nextInt());
            }
            clueC = chal.JouerUnTour(propositionSolution);
            System.out.println(clueC.toString());
            fin = isOver(clueC);
            clueC.clear();
            propositionSolution.clear();
        } while (!fin && chal.nbrRoundC < Configuration.getNbrRoundMax());
    }

    private Boolean isOver(ArrayList<String> clue){

        if (clue.contains(" + ") || clue.contains(" - ")) {
            System.out.println("Il vous reste " + (Configuration.getNbrRoundMax() - chal.nbrRoundC) + "tours!");
        }

        for (int k = 0; k < clue.size(); ++k) {
            if (clue.get(k).equals(" + ")) {
                return false;
            } else if (clue.get(k).equals(" - ")) {
                return false;
            }
        } return true;
    }
}
