package core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentsURL {
    private static String environment(String linkPath) {

        try (InputStream inputStream = EnvironmentsURL.class.getClassLoader().getResourceAsStream("config.pathsite.properties")) {
            Properties propertis = new Properties();
            propertis.load(inputStream);
            return propertis.getProperty(linkPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new NullPointerException("File");
    }
    public static String getPathTraining(){
        return environment("linkTraining.path");
    }
}
