package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class DeleteProductUingScanner
{
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
  Scanner sc=  new Scanner(System.in);
        System.out.println("Enter Id You want Delete");
  int id=sc.nextInt();

        cfg=new Configuration();
        cfg=cfg.configure();
        factory= cfg.buildSessionFactory();
        ses= factory.openSession();
        Product p=ses.get(Product.class,id);
      //  p.setProductName("TV");
        tx=ses.beginTransaction();
        ses.delete(p);
        tx.commit();
        System.out.println("Product Details Deleted");

    }

}
