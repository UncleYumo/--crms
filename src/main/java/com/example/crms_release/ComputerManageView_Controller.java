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
public class ComputerManageView_Controller {
    public TableView<Device> tableView_deviceList;
    public TableColumn<Device, String> column_deviceType;
    public TableColumn<Device, String> column_deviceID;
    public TableColumn<Device, String> column_status;
    public TableColumn<Device, String> column_location;
    public Button button_refreshInfo;
    public TextArea textArea_Log;
    public TextField textField_deviceIDID;
    public TextField textField_deviceType;
    public TextField textField_deviceStatus;
    public Button button_deleteDevice;
    public Button button_changeDeviceInfo;
    public Button button_addDevice;
    public TextField textField_location;
    public Button button_clearLog;

    public ArrayList<String> logList = new ArrayList<>();


    public void initialize() {
        System.out.println("计算机管理界面initialize()方法被调用");
    }

    public void onAction_refreshInfo(ActionEvent actionEvent) {
        System.out.println("刷新设备信息");
    }

    public void onAction_deleteDevice(ActionEvent actionEvent) {
        System.out.println("删除设备");
    }

    public void onAction_changeDeviceInfo(ActionEvent actionEvent) {
        System.out.println("修改设备信息");
    }

    public void onAction_addDevice(ActionEvent actionEvent) {
        System.out.println("添加设备");
    }

    public void onAction_clearLog(ActionEvent actionEvent) {
        System.out.println("清空日志");
    }
}
