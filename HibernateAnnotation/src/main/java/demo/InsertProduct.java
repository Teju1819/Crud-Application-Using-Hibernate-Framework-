package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertProduct
{
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory sessionFactory;
        Session ses;
        Transaction tx;

        //Step1-Activate hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure();
        cfg=cfg.addAnnotatedClass(Product.class);
        //step2-Establish communication link

        sessionFactory= cfg.buildSessionFactory();


        //Step3-Start the session
        ses= sessionFactory.openSession();
        Product p1=new Product(5,"AC","Electronics",54000);
        tx= ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("Product Inserted Successfully....");


    }
}
