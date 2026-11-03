module laboratoire7 {
    requires javafx.controls;
    requires javafx.fxml;

    opens laboratoire7 to javafx.fxml, java.base;
    exports laboratoire7;
}
