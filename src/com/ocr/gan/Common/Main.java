package com.ocr.gan.Common;

import com.ocr.gan.IHM.Game;
import com.ocr.gan.config.Configuration;

public class Main {

    public static void main(String[] args) {

        Configuration.readProperties();
        Game.gameChoice();

    }
}