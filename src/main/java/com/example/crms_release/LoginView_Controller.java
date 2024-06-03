package com.example.crms_release;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

/**
 * @author uncle_yumo·
 * @CreateDate 2024/5/21
 * @School 无锡学院
 * @StudentID 22344131
 * @Description 这是LoginViewController的Java类，负责处理登录界面的逻辑。
 */
public class LoginView_Controller {
    @FXML
    public TextField textField_user;
    @FXML
    public PasswordField passwordField_password;
    @FXML
    public Button button_connect;
    @FXML
    public Button button_login;
    @FXML
    public Circle circle_flag;
    @FXML
    public Label label_isConnected;
    @FXML
    private AnchorPane anchorPane_login;

    private boolean isConnected = false;

    public String userRole = "";

    public void initialize() {
    }
    // anchorPane_login.requestLayout(); // 刷新界面
    public void refreshInfo() {
    }

    public boolean isConnected() {
        return isConnected;
    }
}
