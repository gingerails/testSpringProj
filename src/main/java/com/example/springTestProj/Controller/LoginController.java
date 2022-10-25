package com.example.springTestProj.Controller;

import com.example.springTestProj.Service.UserService;
import com.example.springTestProj.SquizardApplication;
//import com.example.springTestProj.StageInitializer;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import net.rgielen.fxweaver.core.FxmlView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


@Component
@FxmlView("/login.fxml")
public class LoginController{

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

    /**
     * initialize
     * automatically called
     */
    @FXML
    public void initialize () {
        this.button.setOnAction(actionEvent -> {
            System.out.print("Got heere");
            verify();
            try {
                changeScene("/ui.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * Changes the scene
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

    /**
     * Verify user account exists
     */
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