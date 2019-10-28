package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD_2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@Configuration
@PropertySource(value ="classpath:Food2.properties")
public class Config_Food2 {

    @Value("${url}")
    private String url;

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    public DataSource getDatasource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        dataSourceBuilder.driverClassName("org.h2.Driver");
        return dataSourceBuilder.build();
    }


    public JdbcTemplate getJdbcTemplate()
    {
        return new JdbcTemplate(getDatasource());
    }
}
