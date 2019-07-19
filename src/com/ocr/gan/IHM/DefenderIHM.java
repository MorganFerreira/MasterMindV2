package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;
import com.ocr.gan.plusoumoins.Defender;
import org.apache.log4j.Logger;
import resources.Str;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DefenderIHM {
    Defender def;
    Scanner sc = new Scanner(System.in);
    Logger logger = Logger.getLogger(DefenderIHM.class);

    public DefenderIHM(){
        def = new Defender();
    }


    public void Affichage() {

        ArrayList<Integer> propositionIA = new ArrayList<Integer>();
        ArrayList<String> clueH = new ArrayList<>();
        ArrayList<String> possibleClue = new ArrayList<>(Arrays.asList("+", "-", "="));
        Boolean fin = false;

        if (propositionIA.isEmpty()) {
            do {
                propositionIA.add(5);
            } while (propositionIA.size() < Configuration.getNbrValues());
        }

        do {
            logger.info(Str.propositionIa);
            logger.info(propositionIA.toString());
            logger.info("Il reste " + (Configuration.getNbrRoundMax() - def.nbrRoundD) + " tours à l'ordinateur pour trouver votre combinaison!");
            do {
                logger.info(Str.takeClue);
                for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                    String tmp = sc.next();
                    if (possibleClue.contains(tmp)) {
                        clueH.add(tmp);
                    } else {
                        logger.info(Str.incorrectValues);
                        clueH.clear();
                        k = -1;
                    }
                }
            } while (clueH.contains(possibleClue));

            def.JouerUnTour(clueH, propositionIA);

            fin = isOver(clueH);
            clueH.clear();
        } while (!fin && def.nbrRoundD < Configuration.getNbrRoundMax());

    }

    private Boolean isOver(ArrayList<String> clueH) {

        for (int k = 0; k < clueH.size(); ++k) {
            if (clueH.get(k).equals("+")) {
                return false;
            } else if (clueH.get(k).equals("-")) {
                return false;
            }
        } return true;
    }
}
