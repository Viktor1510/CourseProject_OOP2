package com.example.CourseProject_OOP;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        initializeDatabase();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main (String[] args) {
        launch();
    }

    private void initializeDatabase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.createQuery("FROM User").getResultList();

        em.getTransaction().commit();

        em.close();
        emf.close();
    }

}