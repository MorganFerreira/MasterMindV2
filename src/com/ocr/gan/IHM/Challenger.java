package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;
import com.ocr.gan.plusoumoins.Humain;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenger {


    Scanner sc = new Scanner(System.in);
    Logger logger = Logger.getLogger(Challenger.class);


    public Challenger(){}


    // Déroulement du challenger
    public boolean Affichage(){

        ArrayList<String> clueC = new ArrayList<>();
        do {
            clueC = chal.JouerUnTour(propositionSolution);
            System.out.println(clueC.toString());
            fin = isOver(clueC);
            clueC.clear();
            propositionSolution.clear();
        } while (!fin && chal.nbrRoundC < Configuration.getNbrRoundMax());
        return fin;
    }

    // fonction donnant le nbr de tour restant si !win --> need indice ia
    public void tourRestant() {
        if (clue.contains(" + ") || clue.contains(" - ")) {
            logger.info("Il vous reste " + (Configuration.getNbrRoundMax() - chal.nbrRoundC) + "tours!");
        }
    }
}
