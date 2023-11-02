package mybootapp.web.security;

import mybootapp.model.XUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import mybootapp.repo.XUserRepository;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.Set;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    XUserRepository userRepo;

    @Autowired
    PasswordEncoder encoder;

    @PostConstruct
    public void init() {
        /*var aa = new XUser("aaa", encoder.encode("aaa"), Set.of("ADMIN", "USER"));
        var bb = new XUser("bbb", encoder.encode("bbb"), Set.of("USER"));
        userRepo.save(aa);
        userRepo.save(bb);*/
        System.out.println("--- INIT SPRING SECURITY");
    }



    @Override
    public UserDetails loadUserByUsername(String username) {
        var user = userRepo.findById(username);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user.get());
    }
}
