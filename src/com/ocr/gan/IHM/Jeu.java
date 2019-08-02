package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;
import resources.Str;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Jeu {

    public static Scanner sc = new Scanner(System.in);
    public static int choice; // = 0;

    /* fonction retournant un boolean pour verif la win --> need indice

    @param clue --> indice d'un jeu
    @return --> renvoie un Boolean déterminant la fin de partie

     */
    public Boolean isOver(ArrayList<String> clue) {


        for (int k = 0; k < clue.size(); ++k) {
            if (clue.get(k).equals("+")) {
                return false;
            } else if (clue.get(k).equals("-")) {
                return false;
            }
        } return true;
    }

    public void end() {

        int askEnd;
        System.out.println(Str.ruleEndGame);

        do {
            askEnd = sc.nextInt();
        } while (askEnd != 1 && askEnd != 2 && askEnd != 3);

        switch (askEnd) {
            case 1:
                restartSameGame(choice);
                break;
            case 2:
                gameChoice();
                break;
            case 3:
                System.exit(1);
                break;
        }
    }

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

    // fonction donnant le nbr de tour restant si !win --> need indice ia
    public Integer tourRestant(ArrayList<String> clueC, int nbrRound) {
        ++nbrRound;
        if (clueC.contains("+") || clueC.contains("-")) {
            System.out.println("Il vous reste " + (Configuration.getNbrRoundMax() - (nbrRound - 1)) + "tours!");
        } return nbrRound;
    }
}
