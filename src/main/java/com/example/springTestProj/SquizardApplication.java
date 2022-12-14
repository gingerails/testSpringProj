package com.example.springTestProj;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

public class SquizardApplication extends Application{
    private ConfigurableApplicationContext applicationContext;

    private static Scene scene;


    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(SpringTestProjApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws IOException {
        applicationContext.publishEvent(new StageReadyEvent(stage));
//        scene = new Scene(loadFXML("/login.fxml"), 640, 480);
//        stage.setScene(scene);
//        stage.show();
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

//    // newly added
//    public static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }
//
//    private static Parent loadFXML(String fxml) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(SquizardApplication.class.getResource(fxml + ".fxml"));
//        return fxmlLoader.load();
//    }
    /// ********

    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }

        public Stage getStage() {
            return ((Stage) getSource());
        }
    }
}
