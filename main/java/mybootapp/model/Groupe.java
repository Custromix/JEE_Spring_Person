package mybootapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = true)
    private String name;

    @Column(nullable = true)
    @OneToMany
    private Set<Person> persons;



    public Groupe(String _name)
    {
        name =_name;
        persons = new HashSet<>();;
    }

    public Groupe()
    {

    }

    public void Addpers(Person pers)
    {
        persons.add(pers);
    }

}
