package com.example.registrationlogindemo.db;


/*import com.example.registrationlogindemo.models.CarMarks;
import jakarta.persistence.*;

public class AutoPartsDB {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("application.properties");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // Добавление нескольких записей в базу данных
        CarMarks car1 = new CarMarks();
        car1.setBrand("Toyota");
        car1.setModel("Camry");
        entityManager.persist(car1);

        CarMarks car2 = new CarMarks();
        car2.setBrand("Honda");
        car2.setModel("Civic");
        entityManager.persist(car2);

        CarMarks car3 = new CarMarks();
        car3.setBrand("Ford");
        car3.setModel("Mustang");
        entityManager.persist(car3);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}*/