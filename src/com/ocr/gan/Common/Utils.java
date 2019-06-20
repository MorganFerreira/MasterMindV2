package com.ocr.gan.Common;

import com.ocr.gan.moreless.Challenger;
import com.ocr.gan.moreless.Defender;
import com.ocr.gan.moreless.Dual;
import resources.Str;

import java.util.Scanner;
import org.apache.log4j.Logger;


public class Utils {

    public static boolean isEqual = true;
    public static int gameMode = 0;
    public static Logger logger = Logger.getLogger(Utils.class);

    public static void end() {
        int choice;
        Scanner sc = new Scanner(System.in);

        if (isEqual) {
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

    public static void gameChoice(boolean restart) {
        Scanner sc = new Scanner(System.in);
        int choice;

        if (restart) {
            logger.info(Str.modeGame);
            do {
                choice = sc.nextInt();
                Utils.gameMode = choice;
            } while (Utils.gameMode != 1 && Utils.gameMode != 2 && Utils.gameMode != 3);
            switch (Utils.gameMode) {
                case 1:
                    Challenger premierJeu = new Challenger();
                    premierJeu.play();
                    break;
                case 2:
                    Defender secondJeu = new Defender();
                    secondJeu.play();
                    break;
                case 3:
                    Dual troisiemeJeu = new Dual();
                    troisiemeJeu.play();
                    break;
            }
        } else {
            switch (Utils.gameMode) {
                case 1:
                    Challenger premierJeu = new Challenger();
                    premierJeu.play();
                    break;
                case 2:
                    Defender secondJeu = new Defender();
                    secondJeu.play();
                    break;
                case 3:
                    Dual troisiemeJeu = new Dual();
                    troisiemeJeu.play();
                    break;
            }
        }
    }
}

