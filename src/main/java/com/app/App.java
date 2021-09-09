package com.app;

import com.app.controller.Controller;
import com.app.gui.LoginView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        Controller.instance().setStage(stage);
        LoginView loginView=new LoginView();
        Controller.instance().setLoginView(loginView);
        Scene scene=new Scene(loginView, 900, 300);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
        
    }

    public static void main(String[] args) {
        launch();
    }

}