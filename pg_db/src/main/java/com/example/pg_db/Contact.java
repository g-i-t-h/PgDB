package com.example.pg_db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name = "contacts")

public class Contact implements Serializable {
  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;
  
  @Column(name="contact")
  private String contact;
  
  @Column(name="email")
  private String email;
  
  @Column(name="phone")
  private String phone;

  protected Contact() {}

  public Contact(String name, String email, String phone) {
    this.contact = name;
    this.email = email;
    this.phone = phone;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return contact;
  }

  public void setName(String name) {
    this.contact = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  @Override
  public String toString() {
    return id+" "+contact+""+email+""+phone+"\n";  
  }

}


