package com.example.ct.pojo;

import com.example.ct.mysql.MysqlField;
import com.example.ct.mysql.MysqlTable;
import lombok.Data;

import java.security.Timestamp;

@Data
@MysqlTable(name = "device_info", autoCreate = true)
public class AllocateDevice {
    @MysqlField(isPrimaryKey = true, field = "id", type = "int")
    int id;
    @MysqlField(field = "device_identifier", type = "varchar(255)")
    String deviceIdentifier;
    @MysqlField(field = "platform", type = "varchar(50)")
    String platform;
    @MysqlField(field = "device_relative_id", type = "varchar(255)")
    int deviceRelativeId;
    @MysqlField(field = "app_identifier", type = "varchar(255)")
    String appIdentifier;
    @MysqlField(field = "country", type = "varchar(50)")
    String country;
    @MysqlField(field = "task_status", type = "int(11)")
    int taskStatus;
    @MysqlField(field = "allocate_time", type = "datetime")
    Timestamp allocate_time;
    @MysqlField(field = "update_time", type = "datetime")
    Timestamp update_time;
    @MysqlField(field = "alias", type = "varchar(50)")
    String alias;
}
