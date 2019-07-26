package com.ocr.gan.IHM;

import com.ocr.gan.plusoumoins.Humain;
import com.ocr.gan.plusoumoins.Ordinateur;

import java.util.ArrayList;

public class Dual {

    Humain chalDual;
    Ordinateur defDual;
    Challenger ihmChalDual;
    Defender ihmDefDuall;

    // solutionC --> combinaison à deviner
    ArrayList<Integer> solutionC;
    // clueC --> indice donné par l'IA
    ArrayList<String> clueC;

    // solutionH --> combinaison que l'IA doit deviner
    ArrayList<Integer> solutionH;
    // clueH --> indice à remplir pour l'IA
    ArrayList<String> clueH;

    public Dual() {
        chalDual = new Humain();
        defDual = new Ordinateur();
        Challenger ihmChalDual = new Challenger();
        Defender ihmDefDuall = new Defender();
    }

    public void JouerUnTour() {
        ihmChalDual.Affichage();
        ihmDefDuall.Affichage();
        //chalDual.JouerUnTour(solutionC);
        //defDual.JouerUnTour(clueH, solutionH);
    }
}
