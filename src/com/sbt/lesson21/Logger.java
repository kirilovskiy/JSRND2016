package com.sbt.lesson21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Logger implements Runnable {
    String str;

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        try(Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","")) {
            PreparedStatement preparedStatement = conn.prepareStatement("insert into log(str) values(?)");
            preparedStatement.setString(1,str);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
