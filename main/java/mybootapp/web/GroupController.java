package mybootapp.web;

import mybootapp.model.Groupe;
import mybootapp.model.Person;
import mybootapp.repo.GroupRepository;
import mybootapp.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Group")
public class GroupController {



    @Autowired
    GroupRepository repo;

    @Autowired
    PersonRepository rappers;

    @GetMapping
    public ModelAndView getTestData() {


        //mv.getModel().put("data", "Welcome home man");
        return new ModelAndView("Group", "persons", rappers.findAll());

    }

    @RequestMapping("/add")
    public String group(String name, Person person) {
        Groupe G = new Groupe(name);
        G.Addpers(person);

        repo.save(G);
        return "redirect:/Group";
    }
}
