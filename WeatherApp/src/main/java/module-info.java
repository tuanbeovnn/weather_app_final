module fi.tuni.progthree.weatherapp {
    requires spring.core;
    requires spring.beans;
    requires java.sql;
    requires lombok;
    requires javafx.controls;
    requires com.google.gson;
    requires spring.boot.autoconfigure;
    requires net.rgielen.fxweaver.core;
    requires org.slf4j;
    requires spring.boot;
    requires spring.context;
    requires javafx.fxml;
    opens fi.tuni.prog3.weatherapp;
    exports fi.tuni.prog3.weatherapp;

}
