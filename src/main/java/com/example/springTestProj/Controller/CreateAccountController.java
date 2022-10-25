package com.example.springTestProj.Controller;

import com.example.springTestProj.Entities.User;
import com.example.springTestProj.Service.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@ComponentScan
@FxmlView("/createAccount.fxml")
public class CreateAccountController {

    @Autowired
    public UserService userService;

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

    @FXML
    public Hyperlink existingAccountLink;

    @FXML
    public void initialize () {
        this.existingAccountLink.setOnAction(actionEvent -> {
            System.out.print("Link clicked");
            try {
                changeScene("/login.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //    verify();
        });
        this.button.setOnAction(actionEvent -> {
            System.out.println("CReating User");
            createUser();
         //   verify();
        });
    }


    /**
     * Changes the scene. This is being reused a lot. Lets put this in its own class or something.
     * @param fxml
     * @throws IOException
     */
    public void changeScene(String fxml) throws IOException {

        Stage currentStage = (Stage) confirm.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource(fxml));
        Scene newScene = new Scene(root);
        currentStage.setScene(newScene);

        System.out.println("h");
    }

    public void createUser(){

        System.out.println("Verifying User...");

        String username = UsrField.getText();
        String password = PassField.getText();
        System.out.println(userService.returnUserByUsername(username));
        if(userService.returnUserByUsername(username) == null) // there mustn't be any users w that username on this device
        {
            // SAVE NEW USER TO REPOSITORY
            User newUser = userService.createUser(username, password);
            userService.saveUserToRepository(newUser);
            try {
                changeScene("/ui.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else{
            System.out.println("Error: Username taken");
        }
    }
}
