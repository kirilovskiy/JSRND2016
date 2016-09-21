package home.twentieth.src;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CachedProxy implements InvocationHandler {
    Map<Integer,Long> mapFibonachi = new ConcurrentHashMap<>();
    Cachable obj;

    public CachedProxy(Cachable obj) {
        this.obj = obj;
        try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from results");

            while (resultSet.next()) {
                mapFibonachi.put(resultSet.getInt(1), Long.valueOf(resultSet.getString(2)));
                System.out.println("n: " + resultSet.getInt(1) + " result: " + resultSet.getInt(2));
            }
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long result;
        int n = (Integer) args[0];
        if (mapFibonachi.containsKey(n)) {
            result = mapFibonachi.get(n);
            System.out.println("value from cache" + result);
        } else {
            result = (Long) method.invoke(obj, args);
            try (Connection conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
                PreparedStatement statement = conn.prepareStatement("insert into results values(?,?)");
                statement.setInt(1,n);
                statement.setString(2,Long.toString(result));
                statement.execute();
                conn.close();
                mapFibonachi.put(n , result);
                System.out.println("added into cache value: " + n);

            return result;
            }
    }
    return method.invoke(obj,args);
    }

}