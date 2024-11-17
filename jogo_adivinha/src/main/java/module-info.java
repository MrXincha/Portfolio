module com.advinha {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.advinha to javafx.fxml;
    exports com.advinha;
}
