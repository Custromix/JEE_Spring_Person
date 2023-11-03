package mybootapp.web;

import mybootapp.model.Person;
import mybootapp.model.XUser;
import mybootapp.repo.PersonRepository;
import mybootapp.repo.XUserRepository;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/person")
public class PersonController {

    /*
     * Injection de la DAO de manipulation des cours.
     */
    @Autowired
    PersonRepository repo;

    @Autowired
    XUserRepository repoX;

    @Autowired
    ObjectFactory<HttpSession> httpSessionFactory;

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    private Person person;


    @PostConstruct
    public void init() {
        //repo.save(new Person("kilyan","chapuis","test@test.com"));


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
*/
	@RequestMapping("/find")
	public ModelAndView findPerson(String name) {
		final var result = repo.findByNameLike("%" + name + "%");
		return new ModelAndView("person", "courses", result);
	}
    
    @GetMapping("/edit")
    public ModelAndView getEditPage(Principal principal) {
        var user = repoX.findById(principal.getName());


        if (user != null) {
            person = repo.findByUserLike(user.get());
            return new ModelAndView("editPerson", "person", person);
        }else {
            person = new Person();
            person.setFirstname("GROS MICHEL");
            return new ModelAndView("error", "msg", "Person non trouvé");
        }

    }

    @PostMapping("/edit")
    public String editUse(String name, String firstname, String mail, String address, String birthday, String username, String password, Principal principal) {
        if(person == null){
            person = new Person();
            person.setUser(repoX.findById(principal.getName()).get());
        }

        person.setName(name);
        person.setFirstname(firstname);
        person.setMail(mail);
        person.setAdress(address);
        try{
            person.setBirthday(birthday);
        }catch(Exception e){}
        person.getUser().setUserName(username);
        person.getUser().setPassword(encoder.encode(password));

        repo.save(person);

        return "redirect:/edit";
    }
}
