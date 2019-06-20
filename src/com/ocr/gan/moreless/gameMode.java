package com.ocr.gan.moreless;

import resources.Str;
import com.ocr.gan.config.Configuration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import org.apache.log4j.Logger;

public abstract class gameMode {

    static ArrayList<String> possibleClue = new ArrayList<>(Arrays.asList("+", "-", "="));
    public static Logger logger = Logger.getLogger(gameMode.class);

    public void generateCmb(ArrayList<Integer> solution) {
        Random rnd = new Random();
        for (int k = 0; k < Configuration.getNbrValues() ; ++k) {
            solution.add(rnd.nextInt(Configuration.getNbrChoice()));
        }
    }

    public void takeCmb(ArrayList<Integer> combination) {
        Scanner sc = new Scanner(System.in);

        logger.info(Str.takeCmb);
        for (int k = 0; k < Configuration.getNbrValues(); ++k) {
            combination.add(sc.nextInt());
        }
    }

    public void takeClue(ArrayList<String> clue) {
        Scanner sc = new Scanner(System.in);

        logger.info(Str.takeClue);
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
    }
}
