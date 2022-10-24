package com.example.springTestProj.Controller;

import com.example.springTestProj.Service.UserService;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.rgielen.fxweaver.core.FxmlView;


@Component
@FxmlView("/login.fxml")
public class LoginController {

    @Autowired
    UserService userService;

    @FXML
    public Label label;

    @FXML
    public Button button;

    @FXML
    public TextField UsrField;

    @FXML
    public TextField PassField;

    @FXML
    public Label confirm;

    // Automatically called
    public void initialize () {
        this.button.setOnAction(actionEvent -> {
            verify();

        });
    }
    //this.button.setOnAction(actionEvent -> this.label.setText(userService.readUsers().toString()));
    public void verify() {
        System.out.println("Verifying User...");
        String Username=UsrField.getText();
        String Password=PassField.getText();
        if(userService.returnUser(Username, Password) != null) //needs to talk to database and veify the username and passwords
        {
            System.out.println("Found User!");
        }
        else{
            System.out.println("Error: UserName/Password is incorrect! Try Again!");
        }

    }
}