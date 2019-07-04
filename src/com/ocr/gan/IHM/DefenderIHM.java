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

    public void DefenderIhm() {
        def = new Defender();
    }


    public void Affichage() {

        ArrayList<Integer> propositionIA = new ArrayList<Integer>();
        ArrayList<String> clueH = new ArrayList<String>();
        ArrayList<String> possibleClue = new ArrayList<>(Arrays.asList("+", "-", "="));
        Boolean fin = false;

        do {
            propositionIA = def.JouerUnTour(clueH);
            System.out.println(propositionIA.toString());

            do {
                for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                    String tmp = sc.next();
                    if (possibleClue.contains(tmp)) {
                        clue.add(tmp);
                        System.out.println("Test");
                    } else {
                        logger.info(Str.incorrectValues);
                        clue.clear();
                        k = -1;
                    }
                }
            } while (clue.contains(possibleClue));

            fin = isOver(propositionIA);
            propositionIA.clear();
            clueH.clear();
        } while (!fin && def.nbrRoundD < Configuration.getNbrRoundMax());
    }

    //private Boolean isOver(ArrayList<Integer> proposition) {

    //}
}
