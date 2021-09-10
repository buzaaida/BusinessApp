
package com.app.gui.user;

import com.app.controller.Controller;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class UserView extends BorderPane {
    
    private final Button logoutButton=new Button("Logout");
    private EmployeeUserView employeeUserView;
    
    public UserView() {
        employeeUserView=new EmployeeUserView();
        setCenter(employeeUserView);
        
        logoutButton.setText("Logout (" + Controller.instance().getLoggedUser()+")");
        logoutButton.setOnAction(Controller.instance().getEvents().getLogoutEvent());
        HBox logoutBox = new HBox(logoutButton);
        logoutBox.setAlignment(Pos.CENTER);
        logoutBox.setPadding(new Insets(10));
        
        GridPane topPane = new GridPane();
        topPane.add(logoutBox, 0, 0);
        
        setTop(topPane);
    }

    public EmployeeUserView getEmployeeUserView() {
        return employeeUserView;
    }

    public void setEmployeeUserView(EmployeeUserView employeeUserView) {
        this.employeeUserView = employeeUserView;
    }
   
}
