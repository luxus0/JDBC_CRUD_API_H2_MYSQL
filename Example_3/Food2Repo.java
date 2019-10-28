package lukasz.nowogorski.SpringBoot.DATABASE_JDBC_CRUD_2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Food2Repo extends JpaRepository<Food2,Long> {
}
