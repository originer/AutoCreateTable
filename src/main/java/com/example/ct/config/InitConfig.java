package com.example.ct.config;

import com.example.ct.mysql.MysqlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitConfig implements ApplicationListener<ContextRefreshedEvent> {

    @Value("com.example.ct.pojo")
    private String mysqlScanTable;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initMysqlTable();
        System.out.println("****************** config success ********************");
    }

    /**
     * 初始化 mysql 表
     */
    public void initMysqlTable() {
        List<String> packages = new ArrayList();
        packages.add(mysqlScanTable);
        List<String> sqlList = MysqlUtil.initMysqlTable(packages);
        for (String createSql : sqlList) {
            jdbcTemplate.execute(createSql);
        }
    }
}
