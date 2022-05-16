import com.zaxxer.hikari.HikariDataSource;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class Initializer {

    private final Logger logger = Logger.getLogger(this.getClass());
    private String jdbcDriver;
    private String jdbcUrl;
    private String username;
    private String password;
    private HikariDataSource dataSource;
    private Connection connection;

    Initializer(){
        Properties prop = new Properties();
        String propFileName = "mybatis.cfg";
        InputStream configStream = null;
        try{
            configStream = new FileInputStream(propFileName);
            prop.load(configStream);
        } catch (FileNotFoundException e){
            logger.error("mybatis.cfg not exist.",e);
        } catch (IOException e){
            logger.error("IOException.",e);
        }
        jdbcDriver = prop.getProperty("database.driver");
        jdbcUrl = prop.getProperty("database.url");
        username = prop.getProperty("database.username");
        password = prop.getProperty("database.password");
        dataSource = new HikariDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("SQLException",e);
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
