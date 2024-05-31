package io.github.cauzy.model.repository;

import io.github.cauzy.model.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository // contem o exception translator
public class ClientRepository {

    private static String INSERT = "insert into client (name) values (?)";
    private static String SELECT_ALL = "SELECT * FROM CLIENT ";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Client save(Client client) {
        jdbcTemplate.update(INSERT, new Object[] {client.getName()} );
        return client;
    }

    public List<Client> findAll() {
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Client>() {
            @Override
            public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Client(Integer.parseInt(rs.getString("id")) , rs.getString("name"));
            }
        } );
    }
}
