package com.ofloxacin.corejavaii.jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author chens
 * @date 2019/4/29 10:58
 */
public class JDBCTest {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/corejavaii?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
        PrintWriter printWriter = new PrintWriter(System.out);
        DriverManager.setLogWriter(printWriter);
        Connection connection = DriverManager.getConnection(url, "root", "root");
    }
}
