package demo;

import domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class UpdateUsingScanner
{
    public static void main(String[] args) {
        Configuration cfg;
        SessionFactory factory;
        Session ses;
        Transaction tx;
        Scanner sc=  new Scanner(System.in);
        System.out.println("Enter Id You want Update");
        int id=sc.nextInt();
        System.out.println("Which Field You Want To Modify: \n1. Modify Product Name \n2. Modify Product Category \n3. Modify Product Price");
        int choice=sc.nextInt();
        switch (choice)
        {
            case 1:
                System.out.println("Enter Updated Name");
                String name= sc.next();
                cfg=new Configuration();
                cfg=cfg.configure();
                factory= cfg.buildSessionFactory();
                ses= factory.openSession();
                Product p=ses.get(Product.class,id);
                p.setProductName(name);
                tx=ses.beginTransaction();
                ses.update(p);
                tx.commit();
                System.out.println("Product Name updated");
                break;
            case 2:
                System.out.println("Enter Updated Category");
                String category= sc.next();
                cfg=new Configuration();
                cfg=cfg.configure();
                factory= cfg.buildSessionFactory();
                ses= factory.openSession();
                Product p1=ses.get(Product.class,id);
                p1.setProductCategory(category);
                tx=ses.beginTransaction();
                ses.update(p1);
                tx.commit();
                System.out.println("Product Category updated");
                break;
            case 3:
                System.out.println("Enter Updated Price");
                double price= sc.nextDouble();
                cfg=new Configuration();
                cfg=cfg.configure();
                factory= cfg.buildSessionFactory();
                ses= factory.openSession();
                Product p2=ses.get(Product.class,id);
                p2.setProductPrice(price);
                tx=ses.beginTransaction();
                ses.update(p2);
                tx.commit();
                System.out.println("Product Price updated");
                break;



        }



    }
    }
