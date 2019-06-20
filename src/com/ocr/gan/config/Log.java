package com.ocr.gan.config;

import com.ocr.gan.moreless.Defender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Log {

    static Logger logger = Logger.getLogger(Log.class);

    public static void main(String args[]) {
        StringBuilder motif = new StringBuilder();
        //motif.append("Date/heure : %d{yyyy-MM-dd HH:mm:ss.SSS} %n");
        //motif.append("Classe emettrice : %C %n");
        //motif.append("Localisation : %l %n");
        motif.append("%m %n");
        //motif.append("%n");

        PatternLayout layout = new PatternLayout(motif.toString());
        ConsoleAppender appender = new ConsoleAppender(layout);
        logger.addAppender(appender);
        logger.setLevel(Level.DEBUG);

        logger.debug("msg de debogage");
        logger.info("msg d'information");
        logger.warn("msg d'avertissement");
        logger.error("msg d'erreur");
        logger.fatal("msg d'erreur fatale");

    }
}
