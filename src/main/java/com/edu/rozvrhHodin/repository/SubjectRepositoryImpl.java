package com.edu.rozvrhHodin.repository;

import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.repository.entity.StudentSubject;
import com.edu.rozvrhHodin.repository.entity.Subject;
import com.edu.rozvrhHodin.service.ServiceLocator;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class SubjectRepositoryImpl implements SubjectRepository {

    public List<Subject> findAllSubject() {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        return entityManager.createQuery("from Subject", Subject.class).getResultList();
    }

    public List<Subject> findByHourAndDayOfWeek(int hour, DayOfWeek dayOfWeek) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> cq = cb.createQuery(Subject.class);

        Root<Subject> subjectRoot = cq.from(Subject.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

            predicates.add(cb.equal(subjectRoot.get("hour"), hour));

        if (dayOfWeek != null) {
            predicates.add(cb.equal(subjectRoot.get("weekday"), dayOfWeek));
        }

        cq.select(subjectRoot).where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(cq).getResultList();
    }

    public Subject findByID(Long id) {
        return ServiceLocator.createEntityManager().find(Subject.class, id);
    }

    public List<Subject> findByAbbrev(String abbrev) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> cq = cb.createQuery(Subject.class);

        Root<Subject> subjectRoot = cq.from(Subject.class);

        cq.select(subjectRoot).where(cb.equal(subjectRoot.get("abbrev"), abbrev));

        return entityManager.createQuery(cq).getResultList();
    }

    public List<Subject> findByName(String name) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> cq = cb.createQuery(Subject.class);

        Root<Subject> subjectRoot = cq.from(Subject.class);

        cq.select(subjectRoot).where(cb.equal(subjectRoot.get("name"), name));

        return entityManager.createQuery(cq).getResultList();
    }


    public List<Subject> findByStudent(Long id) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> cq = cb.createQuery(Subject.class);

        Root<Subject> subjectRoot = cq.from(Subject.class);
        Join<Subject,StudentSubject> studentSubjectJoin = subjectRoot.join("studentSubjectSet");

        cq.where(cb.equal(studentSubjectJoin.get("student"),id));

        return entityManager.createQuery(cq).getResultList();
    }

    public void saveSubject(Subject subject) {
        EntityManager entityManager = ServiceLocator.createEntityManager();
        entityManager.getTransaction().begin();

        if (subject.getId() == null) {
            entityManager.persist(subject);
        } else {
            entityManager.merge(subject);
        }

        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
