package com.example.crms_release;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;
import java.util.List;

/**
 * @author uncle_yumo
 * @CreateDate 2024/5/22
 * @School 无锡学院
 * @StudentID 22344131
 * @Description
 */
public class ComputerRentView_Controller {

    public TableView<Device> tableView_device;
    public TableColumn<Device, String> column_deviceID;
    public TableColumn<Device, String> column_deviceType;
    public TableColumn<Device, String> column_status;
    public TableColumn<Device, String> column_location;
    public TextArea textArea_operationInfo;
    public Button button_rent;
    public TextField textField_deviceID;
    public Button button_return;
    public TextArea textArea_currentUserInfo;
    public Button button_refresh;
    public TextArea textArea_myRecord;
    public Button button_myRecord;
    public Button button_clearLog;
    private AnchorPane anchorPane;

    List<String> textList = new ArrayList<>();
    List<String> textRecordList = new ArrayList<>();

    public void initialize() {
        System.out.println("电脑租赁界面initialize()方法被调用");
        // 刷新按钮点击前禁止其他操作
        button_rent.setDisable(true);
        button_return.setDisable(true);
        button_clearLog.setDisable(true);
        button_myRecord.setDisable(true);
    }

    public void onAction_refreshTable(ActionEvent actionEvent) {
        textList.add("正在刷新设备列表...\n");
        button_rent.setDisable(false);
        button_return.setDisable(false);
        button_clearLog.setDisable(false);
        button_myRecord.setDisable(false);
    }

    public void onAction_rentDevice(ActionEvent actionEvent) {
        System.out.println("正在借用设备...");
    }

    public void onAction_returnDevice(ActionEvent actionEvent) {
        System.out.println("正在归还设备...");
    }

    public void onAction_getMyRecord(ActionEvent actionEvent) {
        System.out.println("获取我的借用记录");
    }

    public void onAction_ClearLog(ActionEvent actionEvent) {
        System.out.println("清空日志");
    }
}