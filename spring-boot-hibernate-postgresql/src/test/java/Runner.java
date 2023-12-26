//import com.kavish.tutorials.entity.UserInformation;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.query.Query;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//public class Runner {
//    @Test
//    public void crud() {
//
///**First off, you create a session and then open it**/
//
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        create(session);
//        //read(session);
//
//        //update(session);
//        //read(session);
//
//        //delete(session);
//        //read(session);
//
//        session.close();
//    }
//
//    private void delete(Session session) {
//        System.out.println("Deleting Record....");
//        UserInformation subscriber = (UserInformation) session.get(UserInformation.class, 5);
//
//        session.beginTransaction();
//        session.delete(subscriber);
//        session.getTransaction().commit();
//    }
//
//    private void update(Session session) {
//        System.out.println("Updating City...");
//        UserInformation john = session.get(UserInformation.class, 5);
//        john.setCity("Mumbai");
//
//        session.beginTransaction();
//        session.update(john);
//        session.getTransaction().commit();
//
//    }
//
//    private void read(Session session) {
//        Query query = session.createQuery("from UserInformation");
//        List<UserInformation> usersList = query.list();
//
//        System.out.println("Reading user records...");
//        System.out.printf("%-30.30s  %-30.30s%n", "UserId", "FirstName");
//        for (UserInformation users : usersList) {
//            System.out.printf("%-30.30s  %-30.30s%n", users.getUserId(), users.getFirstName());
//        }
//    }
//
//    private void create(Session session) {
//        System.out.println("Adding new User...");
//        UserInformation yaqub = new UserInformation();
//        yaqub.setFirstName("Yaqub");
//        yaqub.setLastName("Varghese");
//        yaqub.setAddress("Pali Hills");
//        yaqub.setCity("Bombay");
//
//
///*User jakob = new User();
//        jakob.setFirstName("Jakob");
//        jakob.setLastName("Swedish");
//        jakob.setAddress("New Bhopal Road");
//        jakob.setCity("Bhopal");*/
//
//
//        session.beginTransaction();
//        session.save(yaqub);
//        //session.save(jakob);
//        session.getTransaction().commit();
//
//    }
//}
//
