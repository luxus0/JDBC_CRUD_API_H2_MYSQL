package spring_boot.spring_boot.Jdbc.Example_1.Query;
import lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Config.DB_Config;
import lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Entity.Food;

import java.sql.*;
public class JDBC_Select_Operation
{
    private static DB_Config config;

    private static String sql = "SELECT id,name, color, wages,country,quality, quantity, price FROM food";

    public static void main(String args[]) throws SQLException {

        Connection connection = DriverManager.getConnection(config.getUrl(),config.getUsername(),config.getPassword());
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next())
        {
                Food food = new Food(resultSet.getLong("id"),
                                    resultSet.getString("name"),
                                    resultSet.getString("color"),
                                    resultSet.getInt("wages"),
                                    resultSet.getString("coutry"),
                                    resultSet.getString("quality"),
                                    resultSet.getString("quantity"),
                                    resultSet.getInt("price") );

                System.out.println(food);
        }

    }
}
