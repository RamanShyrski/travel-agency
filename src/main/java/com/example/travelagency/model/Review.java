package com.example.travelagency.model;

import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"Review\"")
public class Review {
  @Id
  @Column
  private long id;

  @Column
  private GregorianCalendar date;

  @Column
  private String text;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  public Review() {
  }

  public Review(long id, GregorianCalendar date, String text, User user) {
    this.id = id;
    this.date = date;
    this.text = text;
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public GregorianCalendar getDate() {
    return date;
  }

  public void setDate(GregorianCalendar date) {
    this.date = date;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
