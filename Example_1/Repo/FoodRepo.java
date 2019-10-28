package spring_boot.spring_boot.Jdbc.Example_1.Repo;

import lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepo extends JpaRepository<Food,Long> {

   // @Query(value ="SELECT name FROM food",nativeQuery = true)
   // public String filterbyName(@Param("name") String name);
}
