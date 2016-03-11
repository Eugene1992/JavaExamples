import org.hibernate.SessionFactory;
import util.HibernateUtil;


public class HibernateMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        sessionFactory.close();
    }
}
