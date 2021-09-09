
package com.app.controller;

import com.app.entity.User;
import com.app.events.Events;
import com.app.gui.LoginView;
import com.app.gui.admin.AdminView;
import com.app.gui.user.UserView;
import javafx.stage.Stage;


public class Controller {
    
    private Stage stage;
    private LoginView loginView;
    private AdminView adminView;
    private UserView userView;
    private final Events events=new Events();
    
    private User loggedUser;
    
    private Controller() {
        super();
    } 

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    

    public Events getEvents() {
        return events;
    }
    
    

    public LoginView getLoginView() {
        return loginView;
    }

    public void setLoginView(LoginView loginView) {
        this.loginView = loginView;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public UserView getUserView() {
        return userView;
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }
   
    
    private static Controller INSTANCE=null;
    
    public static Controller instance() {
        if (INSTANCE == null) {
            INSTANCE=new Controller();
        }
        return INSTANCE;
    }
    
}
