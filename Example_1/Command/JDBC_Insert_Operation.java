package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Command;


import lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Config.DB_Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Insert_Operation {

    private static DB_Config config;

    private static String sql = "INSERT INTO food (id,name, color, wages,country,quality, quantity, price) VALUES (1,'Potato','red',2,'USA','first','good',4)";

    public static void main(String args[]) throws SQLException {
        Connection connection = DriverManager.getConnection(config.getUrl(),config.getUsername(),config.getPassword());
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }


}
