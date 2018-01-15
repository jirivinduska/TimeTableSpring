package com.edu.rozvrhHodin.repository;

import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.repository.entity.StudentSubject;
import com.edu.rozvrhHodin.repository.entity.Subject;
import com.edu.rozvrhHodin.service.ServiceLocator;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements StudentRepository {
    public List<Student> findAllStudents() {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        return entityManager.createQuery("from Student", Student.class).getResultList();
    }

    public Student findByID(Long id) {
        return ServiceLocator.createEntityManager().find(Student.class, id);
    }

    public List<Student> findByFirstName(String firstName) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> studentRoot = cq.from(Student.class);

        cq.select(studentRoot).where(cb.equal(studentRoot.get("firstName"), firstName));

        return entityManager.createQuery(cq).getResultList();
    }

    public List<Student> findByLastName(String lastName) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> studentRoot = cq.from(Student.class);

        cq.select(studentRoot).where(cb.equal(studentRoot.get("lastName"), lastName));

        return entityManager.createQuery(cq).getResultList();
    }


    public List<Student> findByUserName(String userName) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> studentRoot = cq.from(Student.class);

        cq.select(studentRoot).where(cb.equal(studentRoot.get("userName"), userName));

        return entityManager.createQuery(cq).getResultList();
    }

    public List<Student> findBySubject(Long id){
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> studentRoot = cq.from(Student.class);
        Join<Student,StudentSubject> studentSubjectJoin = studentRoot.join("studentSubjects");

        cq.where(cb.equal(studentSubjectJoin.get("subject"),id));

        return entityManager.createQuery(cq).getResultList();

    }



    public List<Student> findByFirstNameAndLastName(String firstName, String lastName) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> studentRoot = cq.from(Student.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        if (firstName != null) {
            predicates.add(cb.equal(studentRoot.get("firstName"), firstName));
        }
        if (lastName != null) {
            predicates.add(cb.equal(studentRoot.get("lastName"), lastName));
        }

        cq.select(studentRoot).where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(cq).getResultList();
    }

    public void saveStudent(Student student) {
        EntityManager entityManager = ServiceLocator.createEntityManager();
        entityManager.getTransaction().begin();

        if (student.getId() == null) {
            entityManager.persist(student);
        } else {
            entityManager.merge(student);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
