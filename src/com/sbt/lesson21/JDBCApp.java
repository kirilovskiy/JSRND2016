package com.sbt.lesson21;

import java.sql.*;

public class JDBCApp {
    public static void main(String[] args) throws SQLException {
        try(Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","")) {

            /*System.out.println("TYPE_FORWARD_ONLY = "+
                    conn.getMetaData().supportsResultSetType(ResultSet.TYPE_FORWARD_ONLY));

            System.out.println("TYPE_SCROLL_INSENSITIVE = "+
                    conn.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));

            System.out.println("TYPE_SCROLL_SENSITIVE = "+
                    conn.getMetaData().supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE));

            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from songs where id = 25");
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
            /*conn.setAutoCommit(false);
            Savepoint savepoint = conn.setSavepoint();
            statement.addBatch("INSERT INTO USERS VALUES(5, 'Grey5', 'GR5')");
            statement.addBatch("INSERT INTO USERS VALUES(6, 'World6', 'WO6');");
            int[] execBatch = statement.executeBatch();

            conn.rollback(savepoint);*/

            Statement statement = conn.createStatement();

            conn.setAutoCommit(false);
            PreparedStatement preparedStatement = conn.prepareStatement("insert into songs(NAME) values(?)");
            Savepoint savepoint = conn.setSavepoint("MY_FIRST_SAVE_POINT");
            preparedStatement.setString(1,"MySong");
            preparedStatement.execute();
/*
            Logger logger = new Logger();
            logger.setStr("MySong");
            Thread t = new Thread(logger);
            t.start();

            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
*/conn.rollback(savepoint);
            preparedStatement.setString(1,"MySong2");
            preparedStatement.execute();
            conn.commit();
        }
        System.out.println("OK");
    }

}
