package spring_boot.spring_boot.Jdbc.Example_4.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_boot.spring_boot.Jdbc.Example_4.Entity.Registration;

@Repository
public interface Registration_Repo extends JpaRepository<Registration,Long> {
}
