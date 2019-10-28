package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Config;

public class DB_Config
{
    private String url = "jdbc:mysql//localhost:3304/food";
    private String username = "lukasz";
    private String password = "lukasz123";

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
