package com.practice;

import com.practice.model.Subjects;

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
    }
}
