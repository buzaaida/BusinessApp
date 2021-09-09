
package com.app.events;

import com.app.controller.Controller;
import com.app.gui.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;


public class LogoutEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        Controller.instance().setLoggedUser(null);
        LoginView loginView = new LoginView();
        Controller.instance().setLoginView(loginView);
        Scene scene = new Scene(loginView, 900, 300);
        Controller.instance().getStage().setScene(scene);
    }
    
}
