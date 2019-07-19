package com.ocr.gan.plusoumoins;

import com.ocr.gan.IHM.ChallengerIhm;
import com.ocr.gan.IHM.DefenderIHM;

import java.util.ArrayList;

public class Dual {

    Challenger chalDual;
    Defender defDual;
    ChallengerIhm ihmChalDual;
    DefenderIHM ihmDefDuall;

    // solutionC --> combinaison à deviner
    ArrayList<Integer> solutionC;
    // clueC --> indice donné par l'IA
    ArrayList<String> clueC;

    // solutionH --> combinaison que l'IA doit deviner
    ArrayList<Integer> solutionH;
    // clueH --> indice à remplir pour l'IA
    ArrayList<String> clueH;

    public Dual() {
        chalDual = new Challenger();
        defDual = new Defender();
        ChallengerIhm ihmChalDual = new ChallengerIhm();
        DefenderIHM ihmDefDuall = new DefenderIHM();
    }

    public void JouerUnTour() {
        ihmChalDual.Affichage();
        ihmDefDuall.Affichage();
        //chalDual.JouerUnTour(solutionC);
        //defDual.JouerUnTour(clueH, solutionH);
    }
}
