package examples.distributed_programming.messaging.resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JNDIProperties {
    // ---------------------------------------------------------------------------------------------

    private static Properties properties = null;

    // ---------------------------------------------------------------------------------------------

    public static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            try {
                properties.load(new FileInputStream(
                        new File("src/main/java/distributed_programming/"
                                + "messaging/resources/jndi.properties")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return properties;
    }

    // ---------------------------------------------------------------------------------------------
}
