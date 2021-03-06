
package com.app.events;

import com.app.commons.constants.Constants;
import com.app.controller.Controller;
import com.app.level.Level;
import com.app.user.User;
import com.app.gui.LoginView;
import com.app.gui.admin.AdminView;
import com.app.gui.user.UserView;
import com.app.level.LevelAccess;
import com.app.user.UserJpaDao;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;


public class LoginEvent implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        
        LoginView loginView = Controller.instance().getLoginView();
        String username = loginView.getUsername();
        String password = loginView.getPassword();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (username.isEmpty() || password.isEmpty()) {
            //loginView.setMessage(Constants.EMPTY_USERNAME_AND_OR_PASSWORD);
            alert.setContentText(Constants.EMPTY_USERNAME_AND_OR_PASSWORD);
            alert.show();
            return;
        }
        UserJpaDao userJpaDao = new UserJpaDao();
        User user = userJpaDao.login(username, password);
        Controller.instance().setLoggedUser(user);
        if (user == null) {
            //loginView.setMessage(Constants.WRONG_USERNAME_AND_OR_PASSWORD);
            alert.setContentText(Constants.WRONG_USERNAME_AND_OR_PASSWORD);
            alert.show();
            return;
        }
        
        Level userLevel=user.getLevelId();
        BorderPane view;
        if (LevelAccess.ADMIN.getId() == userLevel.getId()) {
            view = new AdminView();
            Controller.instance().setAdminView((AdminView) view);
            Controller.instance().getStage().setTitle("Admin: " + user.getName());
        } else {
            view = new UserView();
            Controller.instance().setUserView((UserView) view);
            Controller.instance().getStage().setTitle("User: " + user.getName());
        }
        Scene scene=new Scene(view, 1000, 400);
        Controller.instance().getStage().setScene(scene);
        
    }
   
}
