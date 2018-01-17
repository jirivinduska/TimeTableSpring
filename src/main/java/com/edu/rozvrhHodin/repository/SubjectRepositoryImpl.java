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

    public List<Subject> findByHourDayOfWeekAndRoomNo(int hour, DayOfWeek dayOfWeek, int roomNo) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> cq = cb.createQuery(Subject.class);

        Root<Subject> subjectRoot = cq.from(Subject.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(cb.equal(subjectRoot.get("hour"), hour));
        predicates.add(cb.equal(subjectRoot.get("roomNo"), roomNo));
        if (dayOfWeek != null) {
            predicates.add(cb.equal(subjectRoot.get("weekday"), dayOfWeek));
        }

        cq.select(subjectRoot).where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(cq).getResultList();
    }


    public List<Subject> findByStudentWeekDayAndHour(Long id, DayOfWeek dayOfWeek, int hour) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> cq = cb.createQuery(Subject.class);

        Root<Subject> subjectRoot = cq.from(Subject.class);
        Join<Subject, StudentSubject> studentSubjectJoin = subjectRoot.join("studentSubjectSet");
        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(cb.equal(subjectRoot.get("hour"), hour));
        if (dayOfWeek != null) {
            predicates.add(cb.equal(subjectRoot.get("weekday"), dayOfWeek));
        }
        predicates.add(cb.equal(studentSubjectJoin.get("student"), id));
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
        Join<Subject, StudentSubject> studentSubjectJoin = subjectRoot.join("studentSubjectSet");

        cq.where(cb.equal(studentSubjectJoin.get("student"), id));

        return entityManager.createQuery(cq).getResultList();
    }


    public List<Subject> findByHour(int hour) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> cq = cb.createQuery(Subject.class);

        Root<Subject> subjectRoot = cq.from(Subject.class);

        cq.select(subjectRoot).where(cb.equal(subjectRoot.get("hour"), hour));

        return entityManager.createQuery(cq).getResultList();
    }


    public List<Subject> findByWeekday(DayOfWeek weekday) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> cq = cb.createQuery(Subject.class);

        Root<Subject> subjectRoot = cq.from(Subject.class);

        cq.select(subjectRoot).where(cb.equal(subjectRoot.get("weekday"), weekday));

        return entityManager.createQuery(cq).getResultList();
    }


    public List<Subject> findByLectorName(String lectorname) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> cq = cb.createQuery(Subject.class);

        Root<Subject> subjectRoot = cq.from(Subject.class);

        cq.select(subjectRoot).where(cb.equal(subjectRoot.get("lectorName"), lectorname));

        return entityManager.createQuery(cq).getResultList();
    }


    public List<Subject> findByRoomNo(int roomNo) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Subject> cq = cb.createQuery(Subject.class);

        Root<Subject> subjectRoot = cq.from(Subject.class);

        cq.select(subjectRoot).where(cb.equal(subjectRoot.get("roomNo"), roomNo));

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
