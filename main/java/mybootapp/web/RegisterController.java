package mybootapp.web;

import mybootapp.model.Groupe;
import mybootapp.model.Person;
import mybootapp.model.XUser;
import mybootapp.repo.GroupRepository;
import mybootapp.repo.PersonRepository;
import mybootapp.repo.XUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
@RequestMapping("/register")
public class RegisterController {

	/*
	 * Injection de la DAO de manipulation des cours.
	 */
	@Autowired
	XUserRepository repo;

	@Autowired
	PersonRepository repoPers;
	@Autowired
	GroupRepository repoG;

	PasswordEncoder encoder = new BCryptPasswordEncoder();

	@GetMapping("")
	public ModelAndView getRegisterPage() {

		return new ModelAndView("register", "group", repoG.findAll());
	}

	@PostMapping("")
	public ModelAndView newPerson(String name, String firstname, String mail, String address, String birthday, String username, String password, long group) {

		var newXuser = new XUser(username, encoder.encode(password), Set.of("USER"));

		var person = new Person(name,firstname,mail,address,birthday, newXuser);
		person.setGroupe(repoG.getGroupeById(group));
		repo.save(newXuser);

		repoPers.save(person);

		return new ModelAndView("register", "name", birthday);
	}


}
