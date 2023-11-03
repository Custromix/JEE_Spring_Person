package mybootapp.repo;


import mybootapp.model.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public interface GroupRepository extends JpaRepository<Groupe, Long> {

	List<Groupe> findByName(String name);

	List<Groupe> findByNameLike(String name);

	Groupe getGroupeById(long id);

}
