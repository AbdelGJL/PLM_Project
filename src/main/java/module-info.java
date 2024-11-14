module com.example.plm {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports com.example.login;
    exports com.example.plm;

    opens com.example.login to javafx.fxml;
    opens com.example.plm to javafx.fxml;
}
