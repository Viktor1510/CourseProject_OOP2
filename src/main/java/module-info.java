module com.example.CourseProject_OOP {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.transaction;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.persistence;
    requires java.persistence;
    requires org.apache.logging.log4j;
    requires lombok;
    requires java.validation;
    requires org.hibernate.orm.core;


    exports com.example.CourseProject_OOP.database.entities;
    exports com.example.CourseProject_OOP;
    exports com.example.CourseProject_OOP.enums;
    opens com.example.CourseProject_OOP.enums to javafx.fxml;
    opens com.example.CourseProject_OOP.database.entities to javafx.fxml, lombok, org.hibernate.orm.core;
    opens com.example.CourseProject_OOP to javafx.fxml, lombok, org.hibernate.orm.core;


}