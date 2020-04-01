package ru.ya.sharding.crud.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ya.sharding.crud.repository.PaymentRepository;
import ru.ya.sharding.crud.repository.UserRepository;
import ru.ya.sharding.model.Payment;

@Service
@RequiredArgsConstructor
public class PaymentService {

  private final PaymentRepository paymentRepository;
  private final UserRepository userRepository;

  public int getStatementOfExpenses(final String name) {
    return paymentRepository.findPaymentsBySender(userRepository.findByName(name));
  }

  public void savePayments(List<Payment> payments) {
    paymentRepository.saveAll(payments);
  }
}
