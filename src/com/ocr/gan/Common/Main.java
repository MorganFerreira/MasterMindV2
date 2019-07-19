package com.ocr.gan.Common;

import com.ocr.gan.config.Configuration;


public class Main {

    public static void main(String[] args) {

        Configuration.readProperties();
       boolean end = true;
       Utils startGame = new Utils();
       startGame.gameChoice(end);








    }
}