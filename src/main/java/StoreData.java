import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class StoreData {

    public static void main(String[] args){
        System.out.println("Hello");
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Employee e1=new Employee();
        //e1.setId(101);
        e1.setName("Badri");
        e1.setSalary(8076540);
        session.save(e1);
        t.commit();
        System.out.println("successfully saved");
        System.out.println("Saved Object is ID "+e1.getId()+" Name is "+e1.getName()+" Salary is "+e1.getSalary());
        factory.close();
        session.close();
    }
}
