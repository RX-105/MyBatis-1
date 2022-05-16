import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    private final Logger logger = Logger.getLogger(this.getClass());

    public static void main(String[] args) {
        Initializer i = new Initializer();
        i.init();
    }
}
