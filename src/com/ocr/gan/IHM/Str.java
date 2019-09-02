package com.ocr.gan.IHM;

import com.ocr.gan.config.Configuration;

public class Str {

    public static final String modeGame =
            "Veuillez choisir le mode de jeux: \n " +
            "1: mode Challenger --> Trouver la réponse en " + Configuration.getNbrRoundMax() + " coups maximum \n " +
            "2: mode Defender --> L'IA doit trouver votre combinaison en " + Configuration.getNbrRoundMax() + " coups maximum \n " +
            "3: mode Dual --> Trouver la combinaison de l'IA avant qu'elle ne devine la votre";

    public static final String ruleChallenger =
            "L'IA choisit " + Configuration.getNbrValues() + " chiffre(s) entre 0 et " + (Configuration.getNbrChoice() - 1) +
            ", vous avez " + Configuration.getNbrRoundMax() + " essaies pour les deviner et gagner la partie. \n" +
            "A chaque propositions ne se résolvant pas par la victoire, un indice vous sera accordé.";

    public static final String ruleDefender =
            "Vous choisissez " + Configuration.getNbrValues() + " chiffre(s) entre 0 et " + (Configuration.getNbrChoice() - 1) +
            ", l'IA à " + Configuration.getNbrRoundMax() + " essaies pour deviner et gagner la partie. \n" +
            "A chaque propositions ne se résolvant pas par sa victoire, vous devez lui donner un indice sous forme de +, -, =.";

    public static final String ruleDual =
            "L'IA choisit " + Configuration.getNbrValues() + " chiffre(s) entre 0 et " + (Configuration.getNbrChoice() - 1) +
            ", ensuite vous choisissez " + Configuration.getNbrValues() + " chiffre(s) entre 0 et " + (Configuration.getNbrChoice() - 1) +
            ". Le premier à deviner la combinaison secrête de l'autre, gagne la partie!";

    public static final String modeDev =
            "Vous êtes en mode développeur. La combinaison secrète à deviner est: ";

    public static final String takeClue =
            "Veuillez entrer " + Configuration.getNbrValues() + " indices, sous forme de +, -, =, séparés d'un espace.";

    public static final String takeCmb =
            "Veuillez entrer " + Configuration.getNbrValues() + " chiffres, séparés d'un espace. Ces chiffres doivent être comprit entre 0 et " + (Configuration.getNbrChoice() - 1);

    public static final String takeCmbDual =
            "C'est à votre tour de jouer! Veuillez entrer " + Configuration.getNbrValues() + " chiffres, séparés d'un espace. Ces chiffres doivent être comprit entre 0 et " + (Configuration.getNbrChoice() - 1);

    public static final String ruleEndGame =
            "Vous avez terminé votre partie. Vous pouvez recommencer le même jeu en tapant 1, choisir un autre jeu en tapant 2 ou fermer le jeu en tapant 3!";

    public static final String win =
            "GG, vous avez gagné!";

    public static final String loose =
            "Dommage, vous avez perdue!";

    public static final String incorrectValues  =
            "Les consignes sont simples, recommence!";

    public static final String propositionIa =
            "La proposition de l'IA est: ";

    public static final String firstPropositionIa =
            "La première proposition de l'IA est: ";

    public static final String clueIa =
            "Ce n'est pas la bonne combinaison! Votre indice est: ";

    public static final String secretCmb =
            "Veuillez entrer votre combinaison secrète. Elle doit comporter " + Configuration.getNbrValues() + " chiffres, séparés d'un espace. Ces chiffres doivent être comprit entre 0 et " + (Configuration.getNbrChoice() - 1);

    public static final String reminderCmb =
            "Votre combinaison secrète est: ";

    public static final String solutionWhenLoose =
            "La solution était: ";
}

