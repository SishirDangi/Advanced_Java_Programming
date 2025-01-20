module org.example.javafxuicontrols {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.javafxuicontrols to javafx.fxml;
    exports org.example.javafxuicontrols;
}
