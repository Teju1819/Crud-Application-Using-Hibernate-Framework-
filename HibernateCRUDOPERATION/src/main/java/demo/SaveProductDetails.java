package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveProductDetails
{
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory sessionFactory;
        Session ses;
        Transaction tx;

        //Step1-Activate hibernate framework
        cfg=new Configuration();
        cfg=cfg.configure();

        //step2-Establish communication link

        sessionFactory= cfg.buildSessionFactory();


        //Step3-Start the session
        ses= sessionFactory.openSession();

        //step4- Create object of domain class
        Product p1=new Product();
        p1.setProductId(4);
        p1.setProductName("Balls");
        p1.setProductCategory("Electronics");
        p1.setProductPrice(670.25);

        //Step5=Start the transaction
        tx= ses.beginTransaction();
        ses.save(p1);
        tx.commit();
        System.out.println("Product Inserted Successfully....");


    }
}
