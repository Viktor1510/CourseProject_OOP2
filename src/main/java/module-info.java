module com.oop.passenger_transport {
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires static lombok;
    requires jakarta.persistence;
    requires org.slf4j;
    requires org.hibernate.orm.core;
    requires static jbcrypt;


    opens com.oop.passenger_transport to javafx.fxml;
    exports com.oop.passenger_transport;
}