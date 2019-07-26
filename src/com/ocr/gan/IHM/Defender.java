package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;
import com.ocr.gan.plusoumoins.Ordinateur;
import org.apache.log4j.Logger;
import resources.Str;

import java.util.ArrayList;
import java.util.Scanner;

public class Defender {


    Scanner sc = new Scanner(System.in);
    Logger logger = Logger.getLogger(Defender.class);


    public Defender(){}


    // Déroulement du defender
    public void Affichage() {
        do {
            logger.info(Str.propositionIa);
            logger.info(propositionIA.toString());
            def.JouerUnTour(clueH, propositionIA);
            fin = isOver(clueH);
            clueH.clear();
        } while (!fin && def.nbrRoundD < Configuration.getNbrRoundMax());
    }

    // le nbr de tour restant --> a revoir
    public void tourRestant() {

            logger.info("Il reste " + (Configuration.getNbrRoundMax() - def.nbrRoundD) + " tours à l'ordinateur pour trouver votre combinaison!");

    }
}
