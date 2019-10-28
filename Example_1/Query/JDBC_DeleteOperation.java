package spring_boot.spring_boot.Jdbc.Example_1.Query;

import lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Config.DB_Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_DeleteOperation
{

    private static DB_Config config;

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(config.getUrl(),config.getUsername(),config.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void deleteById() throws SQLException {
    }

    private static void deleteByid() throws SQLException
    {
         String sql = "DELETE FROM food WHERE food.id > 0";



        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        int rowDelete = preparedStatement.executeUpdate(sql);
        if(rowDelete > 0)
        {
            System.out.println("All database is DELETED");
        }
    }


    public static void deleteByName() throws SQLException
    {
        String sql2 = "DELETE FROM food WHERE food.name = ?";


        PreparedStatement preparedStatement = connection.prepareStatement(sql2);

        preparedStatement.setString(1,"potato");

        int rowDeleteName = preparedStatement.executeUpdate();
        if(rowDeleteName > 0)
        {
            System.out.println("Name is succesfully DELETE");
        }

    }

    public static void deleteByCountry() throws SQLException
    {
        String sql3 = "DELETE FROM food WHERE food.country = ?";


        PreparedStatement preparedStatement = connection.prepareStatement(sql3);

        preparedStatement.setString(1,"potato");

        int rowDeleteName = preparedStatement.executeUpdate();
        if(rowDeleteName > 0)
        {
            System.out.println("Country is succesfully DELETE");
        }

    }

    public static void main(String[] args) throws SQLException {

    deleteById();
    deleteByName();
    deleteByCountry();

    }
}
