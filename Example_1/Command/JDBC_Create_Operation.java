package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Command;

import lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Config.DB_Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Create_Operation
{
    private static DB_Config config;


    private static String sql = "CREATE TABLE 'food' (" +
             " 'id' long NOT NULL  ,\n" +
            " 'name' varchar(100), NOT NULL ,\n" +
            " 'color' varchar(100)\n NOT NULL ,\n" +
            "  'wages' int NOT NULL  ,\n" +
            " ' country' varchar(100) NOT NULL ,\n" +
            "  ' quality'  varchar(100) ,\n" +
            "  'quantity' varchar(100)  ,\n" +
            "   'price' int NOT NULL ,\n )";

    public static void main(String args[]) throws SQLException {


        Connection connection = DriverManager.getConnection(config.getUrl(),config.getUsername(),config.getPassword());
        Statement statement = connection.createStatement();
        statement.executeQuery(sql);


    }
}
