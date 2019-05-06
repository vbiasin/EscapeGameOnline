package fr.openclassrooms.vb.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Property {

        private  static Properties properties;

        public  static Properties getInstance(){
            if(properties==null){
                try {
                    properties = load("config.properties");
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


    }
