package ru.ya.sharding.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@Entity
@RequiredArgsConstructor
public class User implements Serializable {

  @Id
  @GeneratedValue
  private long id;
  private String name;
  private int balance;

  public User(final String name, final int balance) {
    this.name = name;
    this.balance = balance;
  }

  public User(final String name) {
    this(name, 0);
  }

  public void setBalance(final int balance) {
    this.balance = balance;
  }
}
