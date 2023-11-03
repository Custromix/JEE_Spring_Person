package mybootapp;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import mybootapp.model.Groupe;
import mybootapp.model.Person;
import mybootapp.model.XUser;
import mybootapp.repo.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import mybootapp.model.Course;
import mybootapp.repo.CourseRepository;

import java.util.Set;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = CourseRepository.class)
@EntityScan(basePackageClasses = Course.class)
public class Starter extends SpringBootServletInitializer implements WebMvcConfigurer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}
	@Autowired
	GroupRepository repo;
	@PostConstruct
	public void init() {
		Groupe D = new Groupe("GT4");
		repo.save(D);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Starter.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(Starter.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("--- addResourceHandlers");
		registry.addResourceHandler("/webjars/**")//
				.addResourceLocations("/webjars/");
	}

    @Bean("messageSource")
    public MessageSource messageSource() {
        var r = new ReloadableResourceBundleMessageSource();
        r.setBasenames("classpath:product", "classpath:messages");
        return r;
    }
}
