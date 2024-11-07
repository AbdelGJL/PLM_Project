module com.example.plm_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.plm_project to javafx.fxml;
    exports com.example.plm_project;
}