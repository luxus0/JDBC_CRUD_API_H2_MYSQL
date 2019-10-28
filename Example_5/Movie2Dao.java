package lukasz.nowogorski.SpringBoot.JDBC_THYMELEAF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class Movie2Dao {


    private JdbcTemplate jdbcTemplate;


    @Autowired
    public Movie2Dao(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(Movie2 movie2)
    {
        String create = "CREATE TABLE Movie2(id long primary key auto_increment, name varchar(25),year int,lenght int,grade int, description varchar(25))";
        jdbcTemplate.execute(create);


        String sql = "INSERT INTO Movie2 VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(sql,new Object[]{
                movie2.getId(),
                movie2.getName(),
                movie2.getYear(),
                movie2.getLenght(),
                movie2.getGrade(),
                movie2.getDescription()
        });
    }

    public List<Map<String, Object>> read()
    {
        String sql = "SELECT * FROM Movie2";
        return jdbcTemplate.queryForList(sql);
    }


    public void update(String name,int year) {
        Movie2 movie2 = new Movie2();

        String sql = "UPDATE Movie2 SET name = ?,year=? WHERE id > 0";
        jdbcTemplate.update(sql, new Object[]{
                movie2.getName(),
                movie2.getYear()
        });


    }
    public void delete(Movie2 movie)
    {
        String sql = "DELETE * FROM Movie2";
        jdbcTemplate.update(sql);

    }

    @EventListener(ApplicationReadyEvent.class)
    public void saveDB()
    {
        save(new Movie2(1,"aaa",2004,45,4,"dsdfds"));
    }

}
