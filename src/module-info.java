module main.java.com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;
    requires java.sql;
    requires java.prefs;
    requires javafx.web;
    requires java.desktop;

    opens main.java.com.example.demo to javafx.fxml;
    exports  main.java.com.example.demo;
}