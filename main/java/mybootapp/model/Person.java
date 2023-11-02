package mybootapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String firstname;
    private String mail;
    private String adress;
    private Calendar birthday;

    @OneToOne
    private XUser user;

    @ManyToOne
    private Group group;

    public Person(String name, String firstname, String mail, String adress, String birthday, XUser user) {
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
        this.adress = adress;
        try{
            this.setBirthday(birthday);
        }catch (Exception e){
            this.birthday = Calendar.getInstance();
        }

        this.user = user;
    }


    public void setBirthday(String birthday) throws ParseException {
        try{
            DateFormat formatter = new SimpleDateFormat("dd-MMM-yy");
            Date date = (Date)formatter.parse(birthday);
            Calendar cal =Calendar.getInstance();
            cal.setTime(date);
            this.birthday = cal;
        }catch (Exception e){

        }

    }
}
