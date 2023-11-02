package mybootapp.web;

import mybootapp.model.Person;
import mybootapp.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/person")
public class PersonController {

    /*
     * Injection de la DAO de manipulation des cours.
     */
    @Autowired
    PersonRepository repo;

    @PostConstruct
    public void init() {
        //repo.save(new Person("kilyan","chapuis","test@test.com"));

    }

    @RequestMapping("/list")
    public ModelAndView listPersons() {
        return new ModelAndView("person", "persons", repo.findAll());
    }
/*
	@RequestMapping("/new")
	public String newCourse() {
		final var course = new Course(String.format("UE %d", System.currentTimeMillis()));
		repo.save(course);
		return "redirect:/course/list";
	}

	@RequestMapping("/find")
	public ModelAndView findCourses(String name) {
		final var result = repo.findByNameLike("%" + name + "%");
		return new ModelAndView("course", "courses", result);
	}
*/
}
