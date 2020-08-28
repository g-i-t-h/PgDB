package com.example.pg_db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ElementCollection;
import java.util.List;
import java.io.Serializable;


@Entity
@Table(name = "projects")

public class Project implements Serializable {
  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int id;

  @Column(name="title")
  private String title;

  @Column(name="status")
  private String status;

  @ElementCollection
  @Column(name="contacts")
  private List<Integer> contacts;

  protected Project() {}

  public Project(String name, String status, List<Integer> contacts) {
    this.title = name;
    this.status = status;
    this.contacts = contacts;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return title;
  }

  public void setName(String name) {
    this.title = name;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public List<Integer> getContacts() {
    return contacts;
  }

  public void setContacts(List<Integer> contacts) {
    this.contacts = contacts;
  }
  
  @Override
  public String toString() {
    return id+" "+title+""+status+""+contacts.toString()+"\n";  
  }


}
