package com.example.crms_release;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class TableUtils {
    private static TableUtils instance = new TableUtils();
    private String userTable_path = "src/main/resources/table_data/userTable.txt";
    private String deviceTable_path = "src/main/resources/table_data/deviceTable.txt";
    private String changeRecordTable_path = "src/main/resources/table_data/changeRecordTable.txt";

    private User currentUser = null;

    // 单例模式获取实例
    public static TableUtils getInstance() {
        return instance;
    }

    // 获取所有用户信息
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(userTable_path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(",");
                int userID = Integer.parseInt(split[0]);
                String userName = split[1];
                String password = split[2];
                String role = split[3];
                User user = new User(userID, userName, password, role);
                users.add(user);
            }
            System.out.println("读取用户信息成功！--> getAllUsers()");
        } catch (Exception e) {
            System.out.println("读取用户信息失败！--> getAllUsers()");
            System.out.println(e.getMessage());
        }
        return users;
    }

    // 检查网络连接情况
    public boolean connectToDatabase() {
        try {
            URL url = new URL("http://www.baidu.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("用户网络连接正常。");
                return true;  // 网络正常
            } else {
                System.out.println("用户数据库连接异常，状态码：" + responseCode);
                return false;  // 网络异常
            }
        } catch (Exception e) {
            System.out.println("无法检测网络连接。错误：" + e.getMessage());
            return false;  // 网络异常或无法检测
        }
    }

    // 获取当前用户信息
    public User getCurrentUser() {
        return currentUser;
    }

    // 设置当前用户信息
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

}