package com.ig.cfgs;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Load hibernate.cfg.xml and build registry
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.properties") // by default looks for hibernate.cfg.xml in classpath
                    .build();

            // Build SessionFactory
            return new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            throw new ExceptionInInitializerError("SessionFactory creation failed: " + ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
