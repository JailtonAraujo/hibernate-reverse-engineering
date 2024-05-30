package com.project.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buidSessionFactory();
    private static SessionFactory buidSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        } catch(Exception e) {
            System.err.println("SessionFactory creation failed" + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void closeConnection() {
        getSessionFactory().close();
    }
}
