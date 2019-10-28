package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Command;

import lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Config.DB_Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Update_Operation
{
    private static DB_Config config;

    private static String sql = "UPDATE food SET  id = 0,name ='tomato', color='green', wages=2, coutry='Hungary', quality='good', quantity='second', price = 5";

    public static void main(String args[]) throws SQLException {

        Connection connection = DriverManager.getConnection(config.getUrl(),config.getUsername(),config.getPassword());
        Statement statement = connection.createStatement();
        statement.executeUpdate(sql);
    }
}
