package lukasz.nowogorski.SpringBoot.JDBC_THYMELEAF;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConnection {

    @Value("${jdbconnect}")
    private String DbUrl;

    @Value("${jdbcuser}")
    private String user;

    @Value("${jdbcpassword}")
    private String passwd;


    public DataSource getDataSource()
    {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName("com.mysql.jdbc.Driver");
        builder.url(DbUrl);
        builder.username(user);
        builder.password(passwd);
        return builder.build();
    }

    public JdbcTemplate jdbcTemplate()
    {
        return new JdbcTemplate(getDataSource());
    }
}
