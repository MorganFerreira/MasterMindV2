package com.ocr.gan.Common;

import com.ocr.gan.IHM.Challenger;
import com.ocr.gan.IHM.Defender;
import com.ocr.gan.IHM.Dual;
import resources.Str;

import java.util.ArrayList;
import java.util.Scanner;
import org.apache.log4j.Logger;


public class Utils {

    Scanner sc = new Scanner(System.in);
    int choice = 0;
    boolean fin;
    Logger logger = Logger.getLogger(Utils.class);
    Challenger isOverChal = new Challenger();
    Defender isOverDef;


    public Utils() {}


    public void end(boolean fin) {


        // message si win ou loose --> need le boolean verif win
        if (fin) {
            logger.info(Str.win);
        } else {
            logger.info(Str.loose);
        }

        // fonction redirigeant l'humain, après une fin de game --> need boolean verif win ?
        logger.info(Str.ruleEndGame);
        choice = sc.nextInt();
        switch (choice) {
            case 1:gameChoice(false);
                break;
            case 2:gameChoice(true);
                break;
            default: System.exit(1);
        }
    }

    public void gameChoice(boolean end) {

        if (end) {

            // fonction obligeant l'humain a choisir un mode de jeux
            logger.info(Str.modeGame);
            do {
                choice = sc.nextInt();
            } while (choice != 1 && choice != 2 && choice != 3);

            // fonction redirigeant l'humain sur 1 des 3 jeux --> stock son choix
            switch (choice) {
                case 1:
                    Challenger first = new Challenger();
                    fin = first.Affichage();
                    end(fin);
                    break;
                case 2:
                    Defender second = new Defender();
                    second.Affichage();
                    break;
                case 3:
                    Dual ter = new Dual();
                    ter.JouerUnTour();
                    break;
            }
        } else {

            switch (choice) {
                case 1:
                    Challenger first = new Challenger();
                    fin = first.Affichage();
                    end(fin);
                    break;
                case 2:
                    Defender second = new Defender();
                    second.Affichage();
                    break;
                case 3:
                    Dual ter = new Dual();
                    ter.JouerUnTour();
                    break;
            }
        }
    }

    // fonction retournant un boolean pour verif la win --> need indice
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

