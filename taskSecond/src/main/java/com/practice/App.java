package com.practice;

import com.practice.model.Degree;
import com.practice.model.Subjects;
import com.practice.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App{
        private static EntityManager entityManager;


    public static void main( String[] args )
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ManagementPersistenceUnit");

        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        //тут можно было использовать enum, это только для примера
        Subjects  math = new Subjects("Math");
        entityManager.persist(math);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        Subjects english = new Subjects("English");
        entityManager.persist(english);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        Subjects subject = entityManager.find(Subjects.class, math.getId());

        System.out.println(subject.toString());

        Teacher smith = new Teacher("Adam", "Smith", Degree.FIRST);

        smith.addSubjects(math);
        smith.addSubjects(english);
        entityManager.persist(smith);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();

        Teacher foundTeacher = entityManager.find(Teacher.class, smith.getId());

        System.out.println("Smith's subjects: ");
        foundTeacher.getSubjects().forEach(x ->System.out.println(x.toString()));

        entityManager.getTransaction().commit();
    }
}
