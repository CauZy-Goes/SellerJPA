package io.github.cauzy.model.repository;

import io.github.cauzy.model.entity.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientOrdersRepository extends JpaRepository<ClientOrder, Integer> {
}
