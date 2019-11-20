package epamtraining.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvironmentsURL {
    private static String environment(String linkPath, String resources) {
        try (InputStream inputStream = EnvironmentsURL.class.getClassLoader().getResourceAsStream(resources)) {
            Properties propertis = new Properties();
            propertis.load(inputStream);
            return propertis.getProperty(linkPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;
    }
    public static String getPathTraining(String linkSite, String resources){
        return environment(linkSite, resources);
    }
    public static String getUserMail(String mail, String resources){
        return environment(mail, resources);
    }
    public static String getUserPassword(String password, String resources){
        return environment(password, resources);
    }
}
