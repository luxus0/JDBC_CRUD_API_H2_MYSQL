package lukasz.nowogorski.SpringBoot.JDBC_THYMELEAF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MovieApi {


    private Movie2Dao dao;

    @Autowired
    public MovieApi(Movie2Dao dao) {
        this.dao = dao;
    }


        @GetMapping("/getmovie")
        public List<Map<String, Object>> getAllMovie()
        {
           return dao.read();
        }


        @PostMapping("/addmovie")
        public void addMovie(@RequestBody Movie2 movie2)
        {
               dao.save(movie2);
        }

        @PutMapping("/updatemovie")
        public void updateMovie()
        {
            dao.update("Makaron",2005);
        }

        @DeleteMapping
        public void deleteMovie(@RequestBody Movie2 movie)
        {
            dao.delete(movie);
        }


}
