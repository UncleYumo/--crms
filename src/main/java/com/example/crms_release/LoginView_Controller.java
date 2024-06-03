package com.example.crms_release;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

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
    public Label label_title;

    @FXML
    private AnchorPane anchorPane_login;

    // 数据库是否连接成功
    private boolean isConnected = false;
    // 用户是否登录成功
    private boolean isLogined = false;

    public String userRole = "";

    public void initialize() {
        System.out.println("LoginView_Controller initialized");
        // 隐藏登录按钮
        button_login.setDisable(true);
    }

    public boolean isConnected() {
        return isConnected;
    }

    public boolean isLogined() {
        return isLogined;
    }

    public void Button_connectDatabase(ActionEvent event) {
        // 假装连接了数据库
        if (TableUtils.getInstance().connectToDatabase()) {
            isConnected = true;
            label_isConnected.setText("Connected");
            button_login.setDisable(false);
            circle_flag.setFill(javafx.scene.paint.Color.GREEN);
            label_isConnected.setText("数据库已连接！");
            // 使连接数据库按钮不可用
            button_connect.setDisable(true);
            return;
        }
        label_isConnected.setText("连接失败！");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("连接失败");
        alert.setHeaderText("数据库连接失败！");
        alert.setContentText("请老师别急着扣分，先加我QQ：2894661403！");
        alert.showAndWait();
        circle_flag.setFill(javafx.scene.paint.Color.RED);
    }

    public void Button_login(ActionEvent event) {
        String userName = textField_user.getText();
        String password = passwordField_password.getText();
        String role = "";
        // 获取用户表
        ArrayList<User> userList = TableUtils.getInstance().getAllUsers();
        // 遍历用户表，判断用户名和密码是否匹配
        for (User user : userList) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                role = user.getRole();
                isLogined = true;
                if (role.equals("admin")) {
                    userRole = "管理员";
                } else if (role.equals("user")) {
                    userRole = "普通用户";
                } else {
                    userRole = "未知权限";
                }
                // 设置当前登录用户
                TableUtils.getInstance().setCurrentUser(user);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("登录成功");
                alert.setHeaderText("欢迎回来，" + userName + "！您的权限为：" + userRole);
                System.out.println("当前登录用户：" + user.toString());
                alert.showAndWait();
                // 关闭当前窗口
                anchorPane_login.getScene().getWindow().hide();
                return;
            }
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("登录失败");
        alert.setHeaderText("用户名或密码错误！");
        alert.setContentText("请检查用户名和密码是否正确！");
        alert.showAndWait();
        System.out.println("登录失败！--> Button_login()");
    }
}
