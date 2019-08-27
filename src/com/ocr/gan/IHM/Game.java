package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;
import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Game {

    public static Scanner sc = new Scanner(System.in);
    public static int choice;
    Logger logger = Logger.getLogger(Game.class);

    /**
     * Fonction verifiant une condition de victoire
     *
     * @param clue --> L'indice
     * @return Le Boolean déterminant la condition de victoire
     **/
    public Boolean isOver(ArrayList<String> clue) {

        logger.debug("isOver - START - arguments: " + clue);
        for (int k = 0; k < clue.size(); ++k) {
            if (clue.get(k).equals("+")) {
                return false;
            } else if (clue.get(k).equals("-")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Fonction demandant au joueur ce qu'il veux faire en fin de partie
     */
    public void end() {

        System.out.println(Str.ruleEndGame);

        switch (sc.nextInt()) {
            case 1:
                restartSameGame(choice);
                break;
            case 2:
                gameChoice();
                break;
            case 3:
                System.exit(1);
                break;
            default:
                System.out.println(Str.incorrectValues);
                end();
        }
    }

    /**
     * Fonction demandant au joueur quel type de jeux il veux lancer
     *
     * @return choice --> Le choix du mode de jeu du joueur
     */
    public static Integer gameChoice() {

        System.out.println(Str.modeGame);
        do {
            choice = sc.nextInt();
        } while (choice != 1 && choice != 2 && choice != 3);

        switch (choice) {
            case 1:
                Challenger first = new Challenger();
                first.startGame();
                break;
            case 2:
                Defender second = new Defender();
                second.startGame();
                break;
            case 3:
                Dual ter = new Dual();
                ter.startGame();
                break;
        }
        return choice;
    }

    /**
     * Fonction ayant pour unique but la relance du même jeu
     *
     * @param choice --> Le choix du mode de jeu du joueur
     */
    private void restartSameGame(int choice) {

        switch (choice) {
            case 1:
                Challenger first = new Challenger();
                first.startGame();
                break;
            case 2:
                Defender second = new Defender();
                second.startGame();
                break;
            case 3:
                Dual ter = new Dual();
                ter.startGame();
                break;
        }
    }

    /**
     * Fonction donnant le nombre de tour restant
     *
     * @return nbrRound --> Le nombre de tours de la partie
     */
    public Integer roundLeft(ArrayList<String> clueC, int nbrRound) {

        logger.debug("roundLeft - START - arguments: " + clueC + ", " + nbrRound);
        ++nbrRound;
        if (clueC.contains("+") || clueC.contains("-")) {
            System.out.println("Il reste " + (Configuration.getNbrRoundMax() - nbrRound) + "tours!");
        }
        logger.debug("roundLeft - FIN - retour: " + nbrRound);
        return nbrRound;
    }
}
