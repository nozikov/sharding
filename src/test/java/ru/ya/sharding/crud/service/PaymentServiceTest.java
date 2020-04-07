package ru.ya.sharding.crud.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.Verifier;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.ya.sharding.crud.repository.PaymentRepository;
import ru.ya.sharding.crud.repository.UserRepository;
import ru.ya.sharding.model.Payment;
import ru.ya.sharding.model.User;


@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {


  @Mock
  private UserRepository userRepository;
  @Mock
  private PaymentRepository paymentRepository;
  @InjectMocks
  private PaymentService service;
  @Mock
  private User user;

  @Test
  public void getStatementOfExpenses() {
    when(userRepository.findByName("name")).thenReturn(user);
    when(paymentRepository.findPaymentsBySender(user)).thenReturn(1);

    service.getStatementOfExpenses("name");
    verify(userRepository, times(2)).findByName(anyString());
    verify(paymentRepository).findPaymentsBySender(any(User.class));

    Assert.assertEquals(1, service.getStatementOfExpenses("name"));
  }

  @Test
  public void getStatementOfExpensesException() {
    when(userRepository.findByName("name")).thenReturn(null);
    assertThrows(IllegalArgumentException.class, () ->
                  service.getStatementOfExpenses("name"));
  }

  @Test
  public void savePayments() {
    List<Payment> payments = new ArrayList<>();
    service.savePayments(payments);
    verify(paymentRepository).saveAll(payments);
  }
}
