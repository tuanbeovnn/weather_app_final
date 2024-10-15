module fi.tuni.progthree.weatherapp {
    requires spring.core;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires javafx.controls;
    requires javafx.fxml;
    requires net.rgielen.fxweaver.core;
    requires org.slf4j;
    requires spring.webflux;
    requires spring.web;
    requires java.sql;
    requires lombok;
    requires com.google.gson;
    requires org.apache.commons.lang3;
    requires org.hibernate.orm.core;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires java.persistence;
    requires io.hypersistence.utils.hibernate.type;
    requires reactor.core;
    requires java.annotation;

    opens fi.tuni.prog3.weatherapp to spring.core, spring.beans, spring.context;
    opens fi.tuni.prog3.weatherapp.controller to spring.core, spring.beans, javafx.fxml;
    opens fi.tuni.prog3.weatherapp.config to spring.core, spring.beans;
    opens fi.tuni.prog3.weatherapp.service to spring.core, spring.beans;

    exports fi.tuni.prog3.weatherapp;
    exports fi.tuni.prog3.weatherapp.controller;
    exports fi.tuni.prog3.weatherapp.config;
    exports fi.tuni.prog3.weatherapp.service;
    exports fi.tuni.prog3.weatherapp.service.impl;
}