package ru.ya.sharding.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Table(name = "user")
public class User implements Serializable {

  @Id
  @GeneratedValue
  private long id;
  @Column(name = "name")
  private String name;
  @Column(name = "balance")
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
