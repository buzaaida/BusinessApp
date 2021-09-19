
package com.app.gui.admin;

import com.app.controller.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class AdminView extends BorderPane {
    
    private final ToggleButton usersButton=new ToggleButton("Users");
    private final ToggleButton departmentsButton=new ToggleButton("Departments");
    private final ToggleButton jobsButton=new ToggleButton("Jobs");
    private final ToggleButton salaryButoon=new ToggleButton("Salaries");

    private final Button logoutButton=new Button("Logout");
    
    private UserAdminView userAdminView;
    private DepartmentAdminView departmentAdminView;
    private JobAdminView jobAdminView;
    private SalaryAdminView salaryAdminView;
    
    public AdminView() {
        userAdminView=new UserAdminView();
        setCenter(userAdminView);
        
        ToggleGroup toggleGroup = new ToggleGroup();
        usersButton.setToggleGroup(toggleGroup);
        usersButton.setSelected(true);
        usersButton.setOnAction(this::onUsersButtonClick);
        departmentsButton.setToggleGroup(toggleGroup);
        departmentsButton.setOnAction(this::onDepartmentsButtonClick);
        jobsButton.setToggleGroup(toggleGroup);
        jobsButton.setOnAction(this::onJobsButtonClick);
        salaryButoon.setToggleGroup(toggleGroup);
        salaryButoon.setOnAction(this::onSalaryButtonClick);
        
        HBox choiceBox=new HBox();
        choiceBox.setSpacing(5);
        choiceBox.setPadding(new Insets(10));
        choiceBox.getChildren().addAll(usersButton, departmentsButton, jobsButton, salaryButoon);
        
        logoutButton.setText("Logout (" + Controller.instance().getLoggedUser()+")");
        logoutButton.setOnAction(Controller.instance().getEvents().getLogoutEvent());
        HBox logoutBox = new HBox(logoutButton);
        logoutBox.setAlignment(Pos.CENTER);
        logoutBox.setPadding(new Insets(10));
        
        GridPane topPane = new GridPane();
        topPane.add(choiceBox, 0, 0);
        topPane.add(logoutBox, 1, 0);
        
        setTop(topPane);
    }
    
    private void onUsersButtonClick(ActionEvent e){
        userAdminView = new UserAdminView();
        setCenter(userAdminView);
    }
    
    private void onDepartmentsButtonClick(ActionEvent e){
        departmentAdminView = new DepartmentAdminView();
        setCenter(departmentAdminView);
    }
    
    private void onJobsButtonClick(ActionEvent e){
        jobAdminView = new JobAdminView();
        setCenter(jobAdminView);
    }
    
    private void onSalaryButtonClick(ActionEvent e){
        salaryAdminView = new SalaryAdminView();
        setCenter(salaryAdminView);
    }
    

    public UserAdminView getUserAdminView() {
        return userAdminView;
    }

    public void setUserAdminView(UserAdminView userAdminView) {
        this.userAdminView = userAdminView;
    }

    public DepartmentAdminView getDepartmentAdminView() {
        return departmentAdminView;
    }

    public void setDepartmentAdminView(DepartmentAdminView departmentAdminView) {
        this.departmentAdminView = departmentAdminView;
    }

    public JobAdminView getJobAdminView() {
        return jobAdminView;
    }

    public void setJobAdminView(JobAdminView jobAdminView) {
        this.jobAdminView = jobAdminView;
    }

    public SalaryAdminView getSalaryAdminView() {
        return salaryAdminView;
    }

    public void setSalaryAdminView(SalaryAdminView salaryAdminView) {
        this.salaryAdminView = salaryAdminView;
    }
    
    
    
}
