
package com.app.gui.admin;

import com.app.department.Department;
import com.app.department.DepartmentJpaDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;


public class DepartmentAdminView extends VBox {
    
    private final Label titleLabel = new Label("Departments");
    private TableView<Department> departmentTableView = new TableView<>();
    private ObservableList<Department> departments = null;
    
    public DepartmentAdminView() {
        //titleLabel.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10));
        loadTableItems();

        TableColumn<Department, Integer> departmentNumberColumn = new TableColumn<>("Department number");
        departmentNumberColumn.setMinWidth(150);
        departmentNumberColumn.setCellValueFactory(new PropertyValueFactory<Department, Integer>("departmentNumber"));

        TableColumn<Department, String> departmentNameColumn = new TableColumn<>("Department Name");
        departmentNameColumn.setMinWidth(150);
        departmentNameColumn.setCellValueFactory(new PropertyValueFactory<Department, String>("departmentName"));

        departmentTableView.getColumns().addAll(departmentNumberColumn, departmentNameColumn);
        getChildren().addAll(titleLabel, departmentTableView);
    }
    
    private void loadTableItems() {
        departments = FXCollections.observableArrayList(new DepartmentJpaDao().getAll());
        departmentTableView.setItems(departments);
    }
    
}
