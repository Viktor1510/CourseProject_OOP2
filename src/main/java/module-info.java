module com.example.courseproject_oop2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires jakarta.persistence;



    opens com.example.courseproject_oop2 to javafx.fxml;
    exports com.example.courseproject_oop2;

}