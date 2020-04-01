package ru.ya.sharding.crud.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.ya.sharding.crud.service.PaymentService;
import ru.ya.sharding.model.Payment;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

  private final PaymentService paymentService;

  @GetMapping("/report/{name}")
  @ResponseStatus(HttpStatus.OK)
  public int findCostsByName(@PathVariable String name) {
    return paymentService.getStatementOfExpenses(name);
  }

  @RequestMapping("/save/{payments}")
  @ResponseStatus(HttpStatus.CREATED)
  public void savePayments(@PathVariable List<Payment> payments) {
    paymentService.savePayments(payments);
  }

}
