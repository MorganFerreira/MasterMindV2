package com.ocr.gan.moreless;

import resources.Str;
import com.ocr.gan.config.Configuration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class gameMode {

    static ArrayList<String> possibleClue = new ArrayList<>(Arrays.asList("+", "-", "="));

    public void generateCmb(ArrayList<Integer> solution) {
        Random rnd = new Random();
        for (int k = 0; k < Configuration.getNbrValues() ; ++k) {
            solution.add(rnd.nextInt(Configuration.getNbrChoice()));
        }
    }

    public void takeCmb(ArrayList<Integer> combination) {
        Scanner sc = new Scanner(System.in);
        Logger log = Logger.getLogger("");

        log.log(Level.INFO, Str.takeCmb);
        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            combination.add(sc.nextInt());
        }
    }

    public void takeClue(ArrayList<String> clue) {
        Scanner sc = new Scanner(System.in);
        Logger log = Logger.getLogger("");

        log.log(Level.INFO, Str.takeClue);
        do {
            for (int k = 0; k < Configuration.getNbrValues(); ++k) {
                String tmp = sc.next();
                if (possibleClue.contains(tmp)) {
                    clue.add(tmp);
                    System.out.println("Test");
                } else {
                    log.log(Level.INFO, Str.incorrectValues);
                    clue.clear();
                    k = -1;
                }
            }
        } while (clue.contains(possibleClue));
    }
}
