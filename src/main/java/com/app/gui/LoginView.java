
package com.app.gui;

import com.app.controller.Controller;
import com.app.events.Events;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;


public class LoginView extends GridPane {
    
    private final Label usernameLabel=new Label("Username: ");
    private final TextField usernameField=new TextField();
    private final Label passwordLabel=new Label("Password: ");
    private final PasswordField passwordField=new PasswordField();
    private final Button loginButton=new Button("Login");
    private final Button cancelButton=new Button("Cancel");
    private final Label messageLabel=new Label("Message");
    
    public LoginView() {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(10, 10, 10, 10));
        setAlignment(Pos.CENTER);
        
        add(usernameLabel, 0, 0);
        add(usernameField, 1, 0);
        add(passwordLabel, 0, 1);
        add(passwordField, 1, 1);
        
        FlowPane buttonFlowPane=new FlowPane();
        buttonFlowPane.setAlignment(Pos.CENTER_RIGHT);
        buttonFlowPane.setPadding(new Insets(10, 10, 10, 10));
        buttonFlowPane.setVgap(5);
        buttonFlowPane.setHgap(5);
        buttonFlowPane.getChildren().addAll(loginButton, cancelButton);
        
        
        add(buttonFlowPane, 1, 2);
        add(messageLabel, 1, 3);
        
        Events events=Controller.instance().getEvents();
        loginButton.setOnAction(events.getLoginEvent());
        cancelButton.setOnAction(events.getCancelEvent());
        
    }
    
    public String getUsername() {
        return usernameField.getText();
    }
   
    public String getPassword() {
        return passwordField.getText();
    }

    public void setMessage(String message) {
        Optional.ofNullable(message).ifPresent(it->messageLabel.setText(it));
    }
}
