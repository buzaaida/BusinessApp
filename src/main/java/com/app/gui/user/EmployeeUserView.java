
package com.app.gui.user;

import com.app.employee.Employee;
import com.app.employee.EmployeeJpaDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;


public class EmployeeUserView extends VBox {
    
    private final Label titleLabel = new Label("Employee");
    private TableView<Employee> emoloyeeTableView = new TableView<>();
    private ObservableList<Employee> employees = null;
    
    public EmployeeUserView() {
        //titleLabel.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10));
        loadTableItems();

        TableColumn<Employee, Integer> emoloyeeNumberColumn = new TableColumn<>("Employee number");
        emoloyeeNumberColumn.setMinWidth(150);
        emoloyeeNumberColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("employeeNumber"));

        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
        
        TableColumn<Employee, String> surnameColumn = new TableColumn<>("Surame");
        surnameColumn.setMinWidth(150);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("surname"));
        
        TableColumn<Employee, Character> genderColumn = new TableColumn<>("Gender");
        genderColumn.setMinWidth(150);
        genderColumn.setCellValueFactory(new PropertyValueFactory<Employee, Character>("gender"));
        
        TableColumn<Employee, Integer> birthDateColumn = new TableColumn<>("Birth date");
        birthDateColumn.setMinWidth(150);
        birthDateColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("birthDate"));
        
        TableColumn<Employee, Integer> startDateColumn = new TableColumn<>("Start date");
        startDateColumn.setMinWidth(150);
        startDateColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("startDate"));
        
        emoloyeeTableView.getColumns().addAll(emoloyeeNumberColumn, nameColumn, surnameColumn, genderColumn, birthDateColumn, startDateColumn);
        getChildren().addAll(titleLabel, emoloyeeTableView);
        
    }
    
    private void loadTableItems() {
        employees = FXCollections.observableArrayList(new EmployeeJpaDao().getAll());
        emoloyeeTableView.setItems(employees);
    }
    
}
