package org.akhil;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        AlienName an = new AlienName();
        an.setFname("Akhil");
        an.setLname("Agrawal");
        an.setMname("Rajesh");

        Alien akhil=new Alien();
        akhil.setAid(102);
        akhil.setColor("Lavender");
        akhil.setAname(an);
        Configuration config=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        Session session;
            session=config.buildSessionFactory().openSession();
            //session.getTransaction().begin();
            Transaction tx = session.beginTransaction();
           // session.save(akhil);
            //session.persist(akhil);
            akhil=(Alien)session.load(Alien.class,102);
           //  akhil=(Alien)session.get(Alien.class,102);
     //   akhil=(Alien) session.createQuery("from alien_table where aid=102").uniqueResult();

            tx.commit();
            session.getTransaction().commit();




        System.out.println(akhil);

    }
}