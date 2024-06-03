package com.example.crms_release;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uncle_yumo
 * @CreateDate 2024/5/22
 * @School 无锡学院
 * @StudentID 22344131
 * @Description
 */
public class UserManageView_Controller {
    public TableView<User> tableView_UserList;
    public TableColumn<User, String> column_userID;
    public TableColumn<User, String> column_userName;
    public TableColumn<User, String> column_passWorld;
    public TableColumn<User, String> column_userRole;
    public Button button_refreshInfo;
    public TextArea textArea_Log;
    public TextField textField_userID;
    public TextField textField_userName;
    public TextField textField_passWord;
    public Button button_deleteUser;
    public Button button_changeUserInfo;
    public Button button_addUser;
    public TextField textField_userRole;

    public ArrayList<String> logList = new ArrayList<>(); // 日志列表
    public Button button_clearLog;

    public void initialize() {
        // TODO: initialize the view here
        System.out.println("用户管理界面initialize()方法被调用");
    }

    public void onAction_refreshInfo(ActionEvent actionEvent) {
        System.out.println("刷新用户信息");
    }

    public void onAction_deleteUser(ActionEvent actionEvent) {
        System.out.println("删除用户");
    }
    public void onAction_changeUserInfo(ActionEvent actionEvent) {
        System.out.println("修改用户信息");
    }
    public void onAction_addUser(ActionEvent actionEvent) {
        System.out.println("添加用户");
    }

    public void onAction_clearLog(ActionEvent actionEvent) {
        System.out.println("清空日志");
    }
}