package com.app.gui.admin;

import com.app.controller.Controller;
import com.app.level.Level;
import com.app.user.User;
import com.app.level.LevelJpaDao;
import com.app.user.UserJpaDao;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class UserAdminView extends VBox {
    
    private final Label titleLabel = new Label("Users");
    private TableView<User> userTableView = new TableView<>();
    private ObservableList<User> users = null;

    private TextField usernameInput = new TextField();
    private PasswordField passwordInput = new PasswordField();
    private TextField nameInput = new TextField();
    private TextField surnameInput = new TextField();
    private ChoiceBox<Level> levelChoice = new ChoiceBox<>();

    private Button addUserButton = new Button("Add");
    private Button removeUserButton = new Button("Remove");
    
    public UserAdminView() {
        //titleLabel.setFont(new Font("Arial", 20));
        setSpacing(5);
        setPadding(new Insets(10));
        loadTableItems();

        TableColumn<User, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setMinWidth(150);
        usernameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("username"));

        TableColumn<User, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(150);
        nameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("name"));

        TableColumn<User, String> surnameColumn = new TableColumn<>("Surname");
        surnameColumn.setMinWidth(150);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<User, String>("surname"));

        TableColumn<User, String> levelColumn = new TableColumn<>("Level");
        levelColumn.setMinWidth(150);
        levelColumn.setCellValueFactory(new PropertyValueFactory<User, String>("levelId"));

        userTableView.getColumns().addAll(usernameColumn, nameColumn, surnameColumn, levelColumn);
        getChildren().addAll(titleLabel, userTableView, getUserCreation());
    }
    
    private void loadTableItems() {
        users = FXCollections.observableArrayList(new UserJpaDao().getAll());
        userTableView.setItems(users);
    }
    
    private HBox getUserCreation() {
        HBox hBox = new HBox();
        hBox.setSpacing(3);

        usernameInput.setMaxWidth(100);
        usernameInput.setPromptText("Username");
        passwordInput.setMaxWidth(100);
        passwordInput.setPromptText("Password");
        nameInput.setMaxWidth(100);
        nameInput.setPromptText("Name");
        surnameInput.setMaxWidth(100);
        surnameInput.setPromptText("Surname");
        LevelJpaDao levelJpaDao = new LevelJpaDao();
        List<Level> levels = levelJpaDao.getAll();
        ObservableList<Level> observableLevels = FXCollections.observableArrayList(levels);
        levelChoice.setItems(observableLevels);
        levelChoice.setMaxWidth(100);
        addUserButton.setOnAction(this::addOrUpdateUser);
        removeUserButton.setOnAction(this::removeUser);
        hBox.getChildren().addAll(usernameInput, passwordInput, nameInput, surnameInput, levelChoice, addUserButton, removeUserButton);
        return hBox;
    }
    
    private void clearInputs() {
        usernameInput.clear();
        passwordInput.clear();
        nameInput.clear();
        surnameInput.clear();
    }
    
    private void addOrUpdateUser(ActionEvent event) {
        String username = usernameInput.getText();
        UserJpaDao userJpaDao = new UserJpaDao();
        User user = userJpaDao.findByUsername(username);
        if (user == null) {
            user = new User();
        }
        user.setUsername(usernameInput.getText());
        user.setPassword(passwordInput.getText());
        user.setName(nameInput.getText());
        user.setSurname(surnameInput.getText());
        user.setLevelId(levelChoice.getSelectionModel().getSelectedItem());
        if (user.getId() != null) {
            userJpaDao.update(user);
        } else {
            userJpaDao.save(user);
        }
        clearInputs();
        loadTableItems();
    }
    
    private void removeUser(ActionEvent event) {
        User user = userTableView.getSelectionModel().getSelectedItem();
        if (user != null) {
            UserJpaDao userJpaDao = new UserJpaDao();
            userJpaDao.delete(user);
        }
        loadTableItems();
    }
}
