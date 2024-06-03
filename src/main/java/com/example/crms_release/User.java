package com.example.crms_release;

/**
 * @author uncle_yumo
 * @CreateDate 2024/5/23
 * @School 无锡学院
 * @StudentID 22344131
 * @Description
 */
public class User {
    private int userID = -1;
    private String userName;
    private String password;
    private String role = "";

    public User(int userID, String userName, String password, String role) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        if(role.equals("admin")) {
            role = "管理员";
        }else if(role.equals("user")) {
            role = "普通用户";
        }else {
            role = "未知权限";
        }
        if(userID == -1 || userName == null || password == null || role == null) {
            return "当前获取的用户信息为空";
        }
        return "当前获取的用户信息为：" + "  用户ID：" + userID + "  用户名：" + userName + "  密码：" + password.charAt(0) + "******" + "  权限：" + role;
    }

}
