import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUDTest {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();

        // Create
        session.beginTransaction();
        Student s = new Student();
        s.setId(1); s.setName("Ankit"); s.setAge(22);
        session.save(s);
        session.getTransaction().commit();

        // Read
        Student s2 = session.get(Student.class, 1);
        System.out.println(s2.getName());

        // Update
        session.beginTransaction();
        s2.setAge(23);
        session.update(s2);
        session.getTransaction().commit();

        // Delete
        session.beginTransaction();
        session.delete(s2);
        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}
