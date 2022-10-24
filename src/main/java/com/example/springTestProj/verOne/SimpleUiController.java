///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.example.springTestProj.verOne;
//
//import com.example.springTestProj.Service.UserService;
//import javafx.application.HostServices;
//import javafx.fxml.FXML;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SimpleUiController {
//
//    @Autowired
//    private final HostServices hostServices;
//
//    @Autowired
//    private UserService userService;
//
//
//    @FXML
//    public Label label;
//
//    @FXML
//    public Button button;
//
//
//    public SimpleUiController(HostServices hostServices) {
//        this.hostServices = hostServices;
//    }
//
//    @FXML
//    public void initialize () {
//        this.button.setOnAction(actionEvent -> this.label.setText(userService.readUsers().toString())); //this.hostServices.getDocumentBase())
//    }
//}