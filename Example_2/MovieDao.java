package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MovieDao
{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Movie movie)
    {
        String sql = "INSERT INTO Movie VALUES(?,?,?,?,?,?)";
        jdbcTemplate.update(sql,
                movie.getId(),
                movie.getName(),
                movie.getYear(),
                movie.getLenght(),
                movie.getGrade(),
                movie.getDescription()

        );
    }

    public Movie read(Long id)
    {
        String sql = "SELECT * FROM Movie WHERE id = ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql,id);

        Movie movie = new Movie();

        for(Map<String, Object>map : maps)
        {
            movie.setId((Long)map.get("id"));
            movie.setName(map.get("name").toString());
            movie.setYear((int)map.get("year"));
            movie.setLenght((int)map.get("length"));
            movie.setGrade((int)map.get("grade"));
            movie.setDescription(map.get("description").toString());
        }

        return movie;
    }


}
