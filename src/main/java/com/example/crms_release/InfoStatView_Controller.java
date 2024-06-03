package com.example.crms_release;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.util.List;

/**
 * @author uncle_yumo
 * @CreateDate 2024/5/22
 * @School 无锡学院
 * @StudentID 22344131
 * @Description
 */
public class InfoStatView_Controller {
    public TextArea textArea_allInfo;
    public Button button_getAllInfo;

    public void onAction_getAllInfo(ActionEvent actionEvent) {
        // 要求如下
        // 获取所有租借设备的用户信息<ChangeRecordTable>
        // 获取所有设备的状态信息<Device.getStatus()>
        // 获取所有用户的数量<User>
        // 获取所有设备的数量<Device>
        // 获取出租设备目前的总营收<ChangeRecordTable.getAmount()>
        // 显示信息到textArea_allInfo
        // 信息分门别类，用空行分隔，格式美观
        // 要求如上
    }
}
