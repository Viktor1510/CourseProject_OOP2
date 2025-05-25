package com.oop.passenger_transport;

import com.oop.passenger_transport.utils.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Session session = null;

        try {
            session = Connection.getSession();
            session.beginTransaction();

            System.out.println("✅ Connected!");

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
            Connection.shutdown();
        }

        primaryStage.setTitle("My App");
        primaryStage.show();
    }

    public static void main(String[] args) {


        launch();
    }
}