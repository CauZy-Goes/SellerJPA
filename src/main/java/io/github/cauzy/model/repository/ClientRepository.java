package io.github.cauzy.model.repository;

import io.github.cauzy.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    // cuidado que tem camel case

    List<Client> findByNameLike(String name); // querry methods

    List<Client> findByNameOrId(String name, Integer id);

    Client findOneByName(String name);

    boolean existsByName(String name);

//  @Query(value = " select * from client c where c.name like '%:name%' ", nativeQuery = true) // SQL
    @Query(value = " select c from Client c where c.name like :name ") // JPQL
    List<Client> encontrarPorNome(@Param("name") String name); // criei meu propio querry method

    @Query(" delete from Client c where c.name =:name ")
    @Modifying // para update e delete
    void deleteByName( String name);
}
