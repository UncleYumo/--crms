package com.example.crms_release;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class TableUtils {
    private static TableUtils instance = new TableUtils();
    private String userTable_path = "userTable.txt";
    private String deviceTable_path = "deviceTable.txt";
    private String changeRecordTable_path = "changeRecordTable.txt";

    private User currentUser = null;

    // 单例模式获取实例
    public static TableUtils getInstance() {
        return instance;
    }

    // 获取所有用户信息
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        // 使用 ClassLoader 获取资源
//        InputStream is = this.getClass().getClassLoader().getResourceAsStream(userTable_path);
//        if (is == null) {
//            System.out.println("资源记录加载失败！ --> getAllUsers()");
//            return users;  // 注意这里返回空列表表示没有加载到数据
//        }
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(userTable_path)))){
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
            e.printStackTrace();  // 打印堆栈跟踪，帮助诊断问题
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
            System.out.println("正在检查检查网络连接...");
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("网络连接正常！");
                System.out.println("正常尝试连接数据库...");
                // 一秒的延迟，等待数据库连接
                Thread.sleep(1000);
                System.out.println("数据库连接正常！");
                return true;  // 网络正常
            } else {
                System.out.println("用户数据库连接异常，状态码：" + responseCode);
                return false;  // 网络异常
            }
        } catch (Exception e) {
            System.out.println("无法检测网络连接！错误：" + "网络连接超时...");
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