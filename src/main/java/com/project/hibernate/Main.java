package com.project.hibernate;


import com.project.hibernate.generated_sources.People;
import com.project.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.tool.hbm2x.Cfg2JavaTool;
import org.hibernate.tool.hbm2x.POJOExporter;

import java.io.File;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            Query query = session.createQuery("from People", People.class);
            List objs = query.getResultList();
            System.out.println(objs);
        } catch (Exception e) {
            System.err.println(e);
        }


    }
}