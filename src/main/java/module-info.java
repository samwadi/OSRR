module com.example.rros {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.rros to javafx.fxml;
    exports com.example.rros;
}