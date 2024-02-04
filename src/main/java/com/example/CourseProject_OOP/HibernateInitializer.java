package com.example.CourseProject_OOP;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateInitializer {

    private  static SessionFactory sessionFactory ;

    private HibernateInitializer() {
    }

    private static class SingletonHolder {
        private static final HibernateInitializer INSTANCE = new HibernateInitializer();
    }

    public static HibernateInitializer getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static SessionFactory initialize() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.err.println("Initial SessionFactory creation failed: " + e);
                throw new ExceptionInInitializerError(e);
            }
        }
        return sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return initialize();
    }

    public void shutdown() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
