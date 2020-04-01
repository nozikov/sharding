package ru.ya.sharding.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
public class Payment {

  @Id
  @GeneratedValue
  private long id;
  private int amount;
  private User sender;
  private User recipient;

  public Payment(int amount, User sender, User recipient) {
    this.amount = amount;
    this.sender = sender;
    this.recipient = recipient;
  }
}
