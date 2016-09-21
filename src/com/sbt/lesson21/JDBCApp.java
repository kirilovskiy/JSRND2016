package com.sbt.lesson21;

import java.sql.*;

public class JDBCApp {
    public static void main(String[] args) throws SQLException {
        try(Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","")) {
            Statement statement = conn.createStatement();

            /*ResultSet resultSet = statement.executeQuery("select * from songs where id = 25");
            while (resultSet.next()){
                System.out.println("Song name:" + resultSet.getString("NAME") +
                                    " Time:" + resultSet.getBigDecimal("SONG_TIME"));
            }

            PreparedStatement preparedStatement = conn.prepareStatement("select * from songs where id = ?");

            preparedStatement.setString(1, "25");

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println("Song name:" + resultSet.getString("NAME") +
                        " Time:" + resultSet.getBigDecimal("SONG_TIME"));
            }*/
            conn.setAutoCommit(false);
            Savepoint savepoint = conn.setSavepoint();
            statement.addBatch("INSERT INTO USERS VALUES(5, 'Grey5', 'GR5')");
            statement.addBatch("INSERT INTO USERS VALUES(6, 'World6', 'WO6');");
            int[] execBatch = statement.executeBatch();

            conn.rollback(savepoint);
        }
    }
}
