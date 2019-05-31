package com.ocr.gan.Common;

import com.ocr.gan.mastermind.ChallengerMm;
import com.ocr.gan.mastermind.DefenderMm;
import com.ocr.gan.mastermind.DualMm;
import com.ocr.gan.moreless.ChallengerMl;
import com.ocr.gan.moreless.DefenderMl;
import com.ocr.gan.moreless.DualMl;
import resources.Str;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Utils {

    public static boolean isEqual = true;
    public static int difficulties = 0;
    public static int gameMode = 0;

    public static void end() {
        int choice;
        Scanner sc = new Scanner(System.in);
        Logger log = Logger.getLogger("");

        if (isEqual) {
            log.log(Level.INFO, Str.win);
        } else {
            log.log(Level.INFO, Str.loose);
        }

        log.log(Level.INFO, Str.ruleEndGame);
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
        Logger log = Logger.getLogger("");

        if (restart) {
            log.log(Level.INFO, Str.runGame);
            do {
                choice = sc.nextInt();
                Utils.difficulties = choice;
            } while (Utils.difficulties != 1 && Utils.difficulties != 2);

        log.log(Level.INFO, Str.modeGame);

        switch (Utils.difficulties) {
            case 1:
                do {
                    choice = sc.nextInt();
                    Utils.gameMode = choice;
                } while (Utils.gameMode != 1 && Utils.gameMode != 2 && Utils.gameMode != 3);
                switch (Utils.gameMode) {
                    case 1:
                        ChallengerMl premierJeu = new ChallengerMl();
                        premierJeu.play();
                        break;
                    case 2:
                        DefenderMl.play();
                        break;
                    case 3:
                        DualMl.play();
                        break;
                }
                break;
            case 2:
                do {
                    choice = sc.nextInt();
                    Utils.gameMode = choice;
                } while (Utils.gameMode != 1 && Utils.gameMode != 2 && Utils.gameMode != 3);
                switch (Utils.gameMode) {
                    case 1:
                        ChallengerMm.Play();
                        break;
                    case 2:
                        DefenderMm.Play();
                        break;
                    case 3:
                        DualMm.Play();
                        break;
                }
                break;
        }} else {
            switch (Utils.difficulties) {
                case 1:
                    switch (Utils.gameMode) {
                        case 1:
                            ChallengerMl.play();
                            break;
                        case 2:
                            DefenderMl.play();
                            break;
                        case 3:
                            DualMl.play();
                            break;
                    }
                    break;
                case 2:
                    switch (Utils.gameMode) {
                        case 1:
                            ChallengerMm.Play();
                            break;
                        case 2:
                            DefenderMm.Play();
                            break;
                        case 3:
                            DualMm.Play();
                            break;
                    }
                    break;
            }
        }
    }
}

