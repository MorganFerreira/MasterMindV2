package com.ocr.gan.Common;

import com.ocr.gan.IHM.ChallengerIhm;
import com.ocr.gan.IHM.DefenderIHM;
import com.ocr.gan.plusoumoins.Dual;
import resources.Str;

import java.util.Scanner;
import org.apache.log4j.Logger;


public class Utils {

    Scanner sc = new Scanner(System.in);
    int choice = 0;
    boolean end;
    Logger logger = Logger.getLogger(Utils.class);
    ChallengerIhm isOverChal;
    DefenderIHM isOverDef;

    public Utils() {
        isOverChal = new ChallengerIhm();
        isOverDef = new DefenderIHM();
    }

    public void end() {

        end = isOverChal.Affichage();

        if (end) {
            logger.info(Str.win);
        } else {
            logger.info(Str.loose);
        }

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
            logger.info(Str.modeGame);
            do {
                choice = sc.nextInt();
            } while (choice != 1 && choice != 2 && choice != 3);

            switch (choice) {
                case 1:
                    ChallengerIhm first = new ChallengerIhm();
                    first.Affichage();
                    end();
                    break;
                case 2:
                    DefenderIHM second = new DefenderIHM();
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
                    ChallengerIhm first = new ChallengerIhm();
                    first.Affichage();
                    break;
                case 2:
                    DefenderIHM second = new DefenderIHM();
                    second.Affichage();
                    break;
                case 3:
                    Dual ter = new Dual();
                    ter.JouerUnTour();
                    break;
            }
        }
    }
}

