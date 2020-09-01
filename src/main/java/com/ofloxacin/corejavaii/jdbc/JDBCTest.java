package com.ofloxacin.corejavaii.jdbc;

import com.ofloxacin.util.RandomUtil;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author chens
 * @date 2019/4/29 10:58
 */
public class JDBCTest {

    private static final int ROWS = 10_000_000;

    private static final ThreadLocalRandom random = ThreadLocalRandom.current();

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mine?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
        PrintWriter printWriter = new PrintWriter(System.out);
        DriverManager.setLogWriter(printWriter);
        Connection connection = DriverManager.getConnection(url, "root", "root");
        connection.setAutoCommit(false);
        PreparedStatement statement = connection.prepareStatement("INSERT INTO user(name,age,gender,email) VALUES (?,?,?,?)");
        for (int i = 1; i <= ROWS; i++) {
            int gender = random.nextInt(1, 3);
            statement.setString(1, RandomUtil.randomName(gender == 1));
            statement.setInt(2, random.nextInt(16, 40));
            statement.setInt(3, gender);
            statement.setString(4, RandomUtil.randomEmail());
            statement.addBatch();
            if (i % 100000 == 0) {
                System.out.println(i);
                statement.executeLargeBatch();
                connection.commit();
            }
        }
    }
}
