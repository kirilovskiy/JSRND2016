package main.jdbcWork;

import main.logic.Client;
import main.utilContext;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = (Client) utilContext.context.getBean("client");
        client.setId(rs.getLong("id"));
        client.setName(rs.getString("name"));
        return client;
    }
}
