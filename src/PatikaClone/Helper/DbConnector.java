package PatikaClone.Helper;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    private Connection connection=null;
    public Connection connectDB(){
        try {
            this.connection= DriverManager.getConnection(Config.DB_URL,Config.DB_USERNAME,Config.DB_PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return this.connection;
    }

    public static  Connection getInstance(){
        DbConnector db=new DbConnector();
        return db.connectDB();
    }
}

