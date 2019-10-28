package spring_boot.spring_boot.Jdbc.Example_1.Query;

import lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Config.DB_Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_Update_Operation
{
    private static DB_Config config;

    private static String sql = "UPDATE food SET id =? name =?, color=?, wages=? ,country=? ,quality =?, quantity=? , price=? ";


    public static void main(String args[]) throws SQLException {

        Connection connection = DriverManager.getConnection(config.getUrl(),config.getUsername(),config.getPassword());

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"1");
        preparedStatement.setString(2,"Strawberry");
        preparedStatement.setString(3,"Red");
        preparedStatement.setString(4,"1");
        preparedStatement.setString(5,"Deutch");
        preparedStatement.setString(6,"good");
        preparedStatement.setString(7,"third");
        preparedStatement.setString(8,"3");


        int row = preparedStatement.executeUpdate();
        if(row > 0)
        {
            System.out.println("All rows is add to Food database");
        }
    }
}
