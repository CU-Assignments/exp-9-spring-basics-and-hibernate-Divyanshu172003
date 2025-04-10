import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    @Bean
    public Course course() {
        Course c = new Course();
        c.setCourseName("Java");
        c.setDuration(3);
        return c;
    }

    @Bean
    public Student student() {
        Student s = new Student(course());
        s.setName("Ravi");
        return s;
    }
}
