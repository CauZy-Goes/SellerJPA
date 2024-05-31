package io.github.cauzy.model.repository;

import io.github.cauzy.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    // cuidado que tem camel case

    List<Client> findByNameLike(String name); // querry methods

    List<Client> findByNameOrId(String name, Integer id);

    Client findOneByName(String name);

    boolean existsByName(String name);
}
