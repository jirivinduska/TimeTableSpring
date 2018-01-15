package com.edu.rozvrhHodin.repository;

import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.repository.entity.StudentSubject;
import com.edu.rozvrhHodin.service.ServiceLocator;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class StudentSubjectRepositoryImpl implements StudentSubjectRepository {




    public void saveStudentSubject(StudentSubject studentSubject) {
        EntityManager entityManager = ServiceLocator.createEntityManager();
        entityManager.getTransaction().begin();

            entityManager.persist(studentSubject);


        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
