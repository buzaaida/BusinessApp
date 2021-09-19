
package com.app.gui.admin;

import com.app.job.Job;
import com.app.job.JobJpaDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;


public class JobAdminView extends VBox {
    
    private final Label titleLabel = new Label("Job");
    private TableView<Job> jobTableView = new TableView<>();
    private ObservableList<Job> jobs = null;
    
    public JobAdminView() {
        //titleLabel.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10));
        loadTableItems();

        TableColumn<Job, Integer> jobToDateColumn = new TableColumn<>("Job date");
        jobToDateColumn.setMinWidth(150);
        jobToDateColumn.setCellValueFactory(new PropertyValueFactory<Job, Integer>("toDate"));
        
        jobTableView.getColumns().addAll(jobToDateColumn);
        getChildren().addAll(titleLabel, jobTableView);
    }

    private void loadTableItems() {
        jobs= FXCollections.observableArrayList(new JobJpaDao().getAll());
        jobTableView.setItems(jobs);
    }
    
}
