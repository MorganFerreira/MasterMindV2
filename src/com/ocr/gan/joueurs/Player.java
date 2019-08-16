package com.ocr.gan.joueurs;
import java.util.ArrayList;

public interface Player {

    /**
     * Initialisation de la combinaison à deviner
     *
     * @return solutionSolution --> La combinaison secrète générée
     **/
    ArrayList<Integer> initSecretCombi();

    /**
     * Génération de l'indice
     *
     * @param propositionSolution --> La proposition
     * @param secretSolution --> La combinaison secrète
     * @return clue --> L'indice généré
     **/
    ArrayList<String> generationClue(ArrayList<Integer> propositionSolution, ArrayList<Integer> secretSolution);

    /**
     * Génération d'une proposition de combinaison
     *
     * @param propositionSolution --> La proposition
     * @param clue --> L'indice
     * @return propositionSolution --> La proposition générée
     **/
    ArrayList<Integer> generationCombi(ArrayList<Integer> propositionSolution, ArrayList<String> clue);

    }
