package com.ocr.gan.Common;

import com.ocr.gan.IHM.Jeu;
import com.ocr.gan.config.Configuration;


public class Main {

    public static void main(String[] args) {

        Configuration.readProperties();
        Jeu.gameChoice();

    }
}