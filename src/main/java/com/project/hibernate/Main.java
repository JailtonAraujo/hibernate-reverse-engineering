package com.project.hibernate;

import com.project.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Query query = session.createNativeQuery("select * from people");
            List objs = query.getResultList();
            System.out.println(objs);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}