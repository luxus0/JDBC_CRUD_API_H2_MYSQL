package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@Repository
public class Food2Dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public void saveDB(Food2 food2) {
        String sql = "INSERT INTO Food2 VALUES(?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, food2.getId(),
                food2.getName(),
                food2.getColor(),
                food2.getWages(),
                food2.getQuality(),
                food2.getQuantity(),
                food2.getPrice());
    }

    //SELECT
    public List<Map<String, Object>> showById(long id)
    {
        String sql = "SELECT * FROM Food2 WHERE id LIKE ?";
        return jdbcTemplate.queryForList(sql, id);
    }

    public List<Map<String, Object>> showByName(String name)
    {
        String sql = "SELECT * FROM Food2 WHERE name LIKE ?";
        return jdbcTemplate.queryForList(sql,name);
    }

    public List<Map<String,Object>> showByColor(String color)
    {
        String sql = "SELECT * FROM Food2 WHERE color LIKE ?";
        return jdbcTemplate.queryForList(sql, color);
    }

    public List<Map<String,Object>> showByWages(int wages)
    {
        String sql = "SELECT * FROM Food2 WHERE wages LIKE ? ";
        return jdbcTemplate.queryForList(sql, wages);
    }

    public List<Map<String,Object>> showByCountry(String country)
    {
        String sql = "SELECT * FROM Food2 WHERE country LIKE ?";
        return jdbcTemplate.queryForList(sql, country);
    }

    public List<Map<String,Object>> showByQuality(String quality)
    {
        String sql = "SELECT * FROM Food2 WHERE quality LIKE ?";
        return jdbcTemplate.queryForList(sql, quality);
    }

    public List<Map<String,Object>> showByQuantity(String quantity)
    {
        String sql = "SELECT * FROM Food2 WHERE quantity LIKE ?";
        return jdbcTemplate.queryForList(sql, quantity);
    }

    public List<Map<String,Object>> showByPrice(int price)
    {
        String sql = "SELECT * FROM Food2 WHERE price LIKE ?";
        return jdbcTemplate.queryForList(sql, price);
    }

    //DELETE
    /*public void deleteByName(String name)
    {
        String sql = "DELETE FROM Food2 WHERE name LIKE ?";
        jdbcTemplate.update(sql,name);
    }*/

    @EventListener(ApplicationReadyEvent.class)
    public void DBinit()
    {
            saveDB(new Food2(1,"dlerst","bbg",2,"fsdf","dsss","rerfrf",34));
    }





}
