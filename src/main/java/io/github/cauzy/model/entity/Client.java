package io.github.cauzy.model.entity;

import jakarta.persistence.*;

import java.lang.annotation.Target;

@Entity
@Table(name = "client") // se o nome for diferente, se for igual n precisa
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // h2 data base use the AUTO
    @Column(name = "id") // se o nome for diferente, se for igual n precisa
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    public Client() {}

    public Client(String name) {
        this.name = name;
    }

    public Client(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
