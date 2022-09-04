module com.example.devil {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.devil to javafx.fxml;
    exports com.example.devil;
}