package ru.ya.sharding.crud.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.ya.sharding.crud.repository.PaymentRepository;
import ru.ya.sharding.crud.repository.UserRepository;
import ru.ya.sharding.model.Payment;
import ru.ya.sharding.model.User;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentService {

  private final PaymentRepository paymentRepository;
  private final UserRepository userRepository;

  public int getStatementOfExpenses(final String name) {
    log.info("Search payments by name: " + name);
    User user = userRepository.findByName(name);
    if (user == null) {
      throw new IllegalArgumentException("User with the same name does not exist: " + name);
    }
    return paymentRepository.findPaymentsBySender(userRepository.findByName(name));
  }

  public void savePayments(List<Payment> payments) {
    paymentRepository.saveAll(payments);
    log.info("Payments was saved");
  }
}
