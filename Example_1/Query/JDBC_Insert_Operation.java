package spring_boot.spring_boot.Jdbc.Example_1.Query;

import lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Config.DB_Config;
import lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Entity.Food;

import java.sql.*;

public class JDBC_Insert_Operation
{

    private static DB_Config config;

    private static String sql = "INSERT INTO food(name, color, wages,country,quality, quantity, price) VALUES(?,?,?,?,?,?,?)";

    public static void main(String args[]) throws SQLException {

        Connection connection = DriverManager.getConnection(config.getUrl(),config.getUsername(),config.getPassword());
        PreparedStatement statement = connection.prepareStatement(sql);


                            statement.setString(1,"Egg");
                            statement.setString(2,"white");
                            statement.setString(3,"1");
                            statement.setString(4,"Poland");
                            statement.setString(5,"good") ;
                            statement.setString(6,"second");
                            statement.setString(7,"2");


                        int row = statement.executeUpdate(sql);
                        if(row > 0)
                        {
                            System.out.println("FOOD add to Database");
                        }

    }
}
