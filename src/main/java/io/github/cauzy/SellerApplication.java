package io.github.cauzy;

import io.github.cauzy.model.entity.Client;
import io.github.cauzy.model.entity.ClientOrder;
import io.github.cauzy.model.repository.ClientOrdersRepository;
import io.github.cauzy.model.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class SellerApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientRepository clientRepository,
                                  @Autowired ClientOrdersRepository ClientOrdersRepository){
        return args -> {
            Client client = new Client("Caua");
            clientRepository.save(client);
            clientRepository.save(new Client("maria"));

            ClientOrder p = new ClientOrder();
            p.setClient(client);
            p.setOrderDate(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));
            ClientOrdersRepository.save(p);

            Client client1 = clientRepository.findClientFetchClientOrder(client.getId());
            System.out.println(client1);
            System.out.println(client1.getClientOrders());
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SellerApplication.class, args);
    }
}
