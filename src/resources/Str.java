package resources;

import com.ocr.gan.config.Configuration;

public class Str {

    public static final String modeGame =
            "Veuillez choisir le mode de jeux: \n " +
            "1: mode Humain --> Trouver la réponse en " + Configuration.getNbrRoundMax() + " coups maximum \n " +
            "2: mode Ordinateur --> Donner les indices à l'ordinateur \n " +
            "3: mode Dual --> Trouver la réponse avant l'ordinateur";

    public static final String ruleChallenger =
            "L'ordinteur choisit " + Configuration.getNbrValues() + " chiffre(s) entre 0 et " + (Configuration.getNbrChoice() - 1) +
            ", vous avez " + Configuration.getNbrRoundMax() + " essaies pour les deviner et gagner la partie. \n" +
            "A chaque propositions ne se résolvant pas par la victoire, un indice vous sera accordé.";

    public static final String ruleDefender =
            "Vous choisissez " + Configuration.getNbrValues() + " chiffre(s) entre 0 et " + (Configuration.getNbrChoice() - 1) +
            ", l'ordinateur à " + Configuration.getNbrRoundMax() + " essaies pour deviner et gagner la partie. \n" +
            "A chaque propositions ne se résolvant pas par sa victoire, vous devez lui donner un indice sous forme de +, -, =.";

    public static final String takeClue =
            "Veuillez entrer " + Configuration.getNbrValues() + " indices, sous forme de +, -, =, les un après les autres.";

    public static final String takeCmb =
            "Veuillez entrer " + Configuration.getNbrValues() + " chiffres, les un après les autres. Ces chiffres doivent être comprit entre 0 et " + (Configuration.getNbrChoice() - 1);

    public static final String ruleEndGame =
            "Vous avez terminé votre partie. Vous pouvez recommencer le même jeu en tapant 1, choisir un autre jeu en tapant 2 ou fermer le jeu en tapant 3!";

    public static final String win =
            "GG, its a win!";

    public static final String loose =
            "Too bad, u loose!";

    public static final String incorrectValues  =
            "Les consignes sont simples, recommence!";

    public static final String modeDev =
            "La réponse est ";

    public static final String propositionIa =
            "La proposition de l'ordinateur est: ";
}

