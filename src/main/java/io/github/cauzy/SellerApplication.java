package io.github.cauzy;

import io.github.cauzy.model.entity.Client;
import io.github.cauzy.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SellerApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientRepository){
        return args -> {
            clientRepository.save(new Client("Caua"));
            clientRepository.save(new Client("maria"));

            List<Client> allClients = clientRepository.findAll();
            allClients.forEach(System.out::println);

            allClients.forEach( c -> {
                c.setName(c.getName() + " atualizado.");
                clientRepository.update(c);
            });

            clientRepository.findByName("ma").forEach(System.out::println);

            allClients = clientRepository.findAll();
            allClients.forEach(System.out::println);

            clientRepository.delete(1);

            allClients = clientRepository.findAll();
            allClients.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SellerApplication.class, args);
    }
}
