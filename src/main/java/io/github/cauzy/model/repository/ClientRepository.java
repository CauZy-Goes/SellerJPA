package io.github.cauzy.model.repository;

import io.github.cauzy.model.entity.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository // contem o exception translator
public class ClientRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Client save(Client client) {
        entityManager.persist(client); // add
        return client;
    }

    @Transactional
    public void delete(Client client) {
        if(!entityManager.contains(client)) {
            client = entityManager.merge(client);
        }
            entityManager.remove(client);
    }

    @Transactional
    public void delete(int id) {
        delete(entityManager.find(Client.class, id));
    }

    @Transactional
    public Client update(Client client) {
        entityManager.merge(client);
        return client;
    }

    @Transactional(readOnly = true) //optimiza
    public List<Client> findByName(String name) {
        String jpql = "select c from Client c where c.name like :name";
        TypedQuery<Client> query = entityManager.createQuery(jpql, Client.class);
        query.setParameter("name", "%" + name + "%");
        return query.getResultList();
    }

    @Transactional(readOnly = true) //optimiza
    public List<Client> findAll() {
        return entityManager.createQuery("from Client ", Client.class).getResultList();
    }
}
