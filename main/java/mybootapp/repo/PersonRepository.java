package mybootapp.repo;

import mybootapp.model.Course;
import mybootapp.model.Person;
import mybootapp.model.XUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PersonRepository extends JpaRepository<Person, String> {
    List<Person> findByNameLike(String name);

    List<Person> findByUserLike(XUser user);
}
