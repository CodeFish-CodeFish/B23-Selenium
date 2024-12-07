package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    public static String readProperty(String key){

        // The location of the file
        File file = new File("configuration.properties");

        // This will help us to read that file
        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream(file));
        }catch (IOException e){
            throw new RuntimeException(e);
        }

        // Returns the value of key from that file
        return properties.getProperty(key);

    }


}
