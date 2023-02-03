package org.example.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataProperties {

    public static String getTestData(String key) {
        Properties prop = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/test/resources/TestData.properties");
            prop.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("FILE NOT FOUND");
        }
        catch (IOException e)
        {
            System.out.println("INPUT OUTPUT EXCEPTION");
        }
        return prop.getProperty(key);
    }
}
