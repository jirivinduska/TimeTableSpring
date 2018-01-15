package com.edu.rozvrhHodin.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ServiceLocator {

    private static final String PERSISTENCE_UNIT_NAME = "rozvrh";

    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;
    private static EntityManagerFactory entityManagerFactory;
    private static StudentService studentService;
    private static SubjectService subjectService;
    private static StudentSubjectService studentSubjectService;

    private ServiceLocator() {

    }
    public static StudentSubjectService getStudentSubjectService(){
        if (studentSubjectService == null) {
            studentSubjectService = new StudentSubjectServiceImpl();
        }

        return studentSubjectService;
    }
    public static StudentService getStudentService() {
        if (studentService == null) {
            studentService = new StudentServiceImpl();
        }

        return studentService;
    }
    public static SubjectService getSubjectService() {
        if (subjectService == null) {
            subjectService = new SubjectServiceImpl();
        }

        return subjectService;
    }

    public static EntityManager createEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }

    public static Session createSession() {
        return getSessionFactory().openSession();
    }

    public static void closeSession(Session session) {
        session.close();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();

                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);

                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();

                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }

        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
