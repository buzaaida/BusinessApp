
package com.app.gui.admin;

import com.app.salary.Salary;
import com.app.salary.SalaryJpaDao;
import java.math.BigDecimal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;


public class SalaryAdminView extends VBox {
    
    private final Label titleLabel = new Label("Salary");
    private TableView<Salary> salaryTableView = new TableView<>();
    private ObservableList<Salary> salaries = null;
    
    public SalaryAdminView() {
        //titleLabel.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10));
        loadTableItems();

        TableColumn<Salary, BigDecimal> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setMinWidth(150);
        salaryColumn.setCellValueFactory(new PropertyValueFactory<Salary, BigDecimal>("salary"));

        TableColumn<Salary, Integer> toDateColumn = new TableColumn<>("To date");
        toDateColumn.setMinWidth(150);
        toDateColumn.setCellValueFactory(new PropertyValueFactory<Salary, Integer>("toDate"));
        
        TableColumn<Salary, Boolean> paidColumn = new TableColumn<>("Paid");
        paidColumn.setMinWidth(150);
        paidColumn.setCellValueFactory(new PropertyValueFactory<Salary, Boolean>("paid"));

        salaryTableView.getColumns().addAll(salaryColumn, toDateColumn, paidColumn);
        getChildren().addAll(titleLabel, salaryTableView);
    }
    
    private void loadTableItems() {
        salaries = FXCollections.observableArrayList(new SalaryJpaDao().getAll());
        salaryTableView.setItems(salaries);
    }
    
}
