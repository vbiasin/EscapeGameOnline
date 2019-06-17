package fr.openclassrooms.vb.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

        private  static Properties properties;
        private static Logger log = LogManager.getLogger(Property.class);

        public  static Properties getInstance(){
            if(properties==null){
                try {
                    properties = load("./config.properties");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return properties;
        }

        /**
         * Charge la liste des propriétés contenu dans le fichier spécifié
         *
         * @param filename le fichier contenant les propriétés
         * @return un objet Properties contenant les propriétés du fichier
         */
        public static Properties load(String filename) throws IOException, FileNotFoundException {
            InputStream input = new FileInputStream(filename);
            try {
                Properties properties = new Properties();
                properties.load(input);
                return properties;
            } finally {
                input.close();
            }
        }

        public static int getLengthOfCombination(){
            int length = Integer.parseInt(getInstance().getProperty("lengthOfCombination","4"));
            if(length<1){
                log.error("New Combination with negativ or null length ");
                throw new IllegalArgumentException();

            }

            return length;
        }

        public static int getNumberOfStrikes(){
            int numberOfStrikes = Integer.parseInt(getInstance().getProperty("numberOfStrikes","20"));
            if(numberOfStrikes<1){
                log.error("The number of strikes is negativ or null");
                throw new IllegalArgumentException();

            }
        return numberOfStrikes;
        }

}
