package com.edu.rozvrhHodin.repository;

import com.edu.rozvrhHodin.repository.entity.Student;
import com.edu.rozvrhHodin.repository.entity.StudentSubject;
import com.edu.rozvrhHodin.repository.entity.Subject;
import com.edu.rozvrhHodin.service.ServiceLocator;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StudentSubjectRepositoryImpl implements StudentSubjectRepository {


    public StudentSubject findStudentOnSubject(Long idStudent, Long idSubject) {
        EntityManager entityManager = ServiceLocator.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<StudentSubject> cq = cb.createQuery(StudentSubject.class);

        Root<StudentSubject> studentSubjectRoot = cq.from(StudentSubject.class);
        List<Predicate> predicates = new ArrayList<Predicate>();
        if (idStudent != null)
            predicates.add(cb.equal(studentSubjectRoot.get("student"), idStudent));
        if (idSubject != null)
            predicates.add(cb.equal(studentSubjectRoot.get("subject"), idSubject));

        cq.select(studentSubjectRoot).where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(cq).getSingleResult();
    }

    public void saveStudentSubject(StudentSubject studentSubject) {
        EntityManager entityManager = ServiceLocator.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(studentSubject);


        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteStudentSubject(StudentSubject studentSubject) {
        EntityManager entityManager = ServiceLocator.createEntityManager();
        entityManager.getTransaction().begin();

        if (entityManager.contains(studentSubject))
            entityManager.remove(studentSubject);
        else {
            studentSubject = entityManager.merge(studentSubject);
            entityManager.remove(studentSubject);
        }

        //  entityManager.remove(entityManager.contains(studentSubject) ? studentSubject : entityManager.merge(studentSubject));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
