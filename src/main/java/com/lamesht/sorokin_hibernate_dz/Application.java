package com.lamesht.sorokin_hibernate_dz;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext("com.lamesht.sorokin_hibernate_dz");

        SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);

        Session session = sessionFactory.openSession();


        session.beginTransaction();
        session.getTransaction().commit();

        session.close();
    }
}
