module com.example.bookstore {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bookstore to javafx.fxml;
    exports com.example.bookstore;
    exports com.example.bookstore.utilities;
    opens com.example.bookstore.utilities to javafx.fxml;
    exports com.example.bookstore.listitems;
    opens com.example.bookstore.listitems to javafx.fxml;
    exports com.example.bookstore.customclasses;
    opens com.example.bookstore.customclasses to javafx.fxml;
}