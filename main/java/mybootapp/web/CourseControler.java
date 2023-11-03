package mybootapp.web;

import javax.annotation.PostConstruct;

import mybootapp.model.XUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mybootapp.model.Course;
import mybootapp.repo.CourseRepository;

import java.util.Set;

@Controller
@RequestMapping("/course")
public class CourseControler {

	/*
	 * Injection de la DAO de manipulation des cours.
	 */
	@Autowired
	CourseRepository repo;

	@RequestMapping("/list")
	public ModelAndView listCourses() {
		return new ModelAndView("course", "courses", repo.findAll());
	}

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

}
