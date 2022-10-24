package com.example.springTestProj.Controller;

import com.example.springTestProj.Service.UserService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/ui.fxml")
public class SimpleController {
    @Autowired
    UserService userService;

    @FXML
    public Label label;

    @FXML
    public Button button;

    @FXML
    public void initialize () {
        this.button.setOnAction(actionEvent -> this.label.setText(userService.readUsers().toString())); //this.hostServices.getDocumentBase())
    }
}
