package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DB_Config
{


    @Value("${datasource.url}")
    private String url;

    @Value("${db.username}")
    private String dbUsername;

    @Value("${db.password}")
    private String dbPassword;


    public DataSource getDataSource()
    {
        DataSourceBuilder builder = DataSourceBuilder.create();
        builder.driverClassName("com.mysql.jdbc.Driver");
        builder.url(url);
        builder.username(dbUsername);
        builder.password(dbPassword);
        return builder.build();
    }




    @Bean
    public JdbcTemplate jdbcTemplate()
    {
        return new JdbcTemplate(getDataSource());
    }

}
