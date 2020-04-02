package ru.ya.sharding.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@RequiredArgsConstructor
public class Payment implements Serializable {

  @Id
  @GeneratedValue
  private long id;
  private int amount;
  @ManyToOne
  private User sender;
  @ManyToOne
  private User recipient;

  public Payment(int amount, User sender, User recipient) {
    this.amount = amount;
    this.sender = sender;
    this.recipient = recipient;
  }
}
