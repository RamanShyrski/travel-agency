package com.example.travelagency.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"user\"")
public class User {

  @Id
  @Column(name = "id")
  private long id;

  @Column
  private String login;

  @Column
  private String password;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User() {}

  public User(long id, String login, String password) {
    this.id = id;
    this.login = login;
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", login='" + login + '\'' +
      ", password='" + password + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    User user = (User)o;
    return id == user.id &&
      Objects.equals(login, user.login) &&
      Objects.equals(password, user.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, login, password);
  }
}
