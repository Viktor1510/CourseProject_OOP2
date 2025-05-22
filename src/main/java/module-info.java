module com.oop2.passenger_transport {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires static lombok;
    requires jakarta.persistence;

    opens com.oop2.passenger_transport to javafx.fxml;
    exports com.oop2.passenger_transport;
}