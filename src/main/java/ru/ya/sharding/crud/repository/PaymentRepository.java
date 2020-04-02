package ru.ya.sharding.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ya.sharding.model.Payment;
import ru.ya.sharding.model.User;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

  int findPaymentsBySender(User user);
}
