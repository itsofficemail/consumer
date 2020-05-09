package com.customer.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public abstract class Persistable implements Serializable {

  /** */
  private static final long serialVersionUID = 8414163481495304970L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID", updatable = false, nullable = false)
  private Integer id;

  @CreatedDate
  @Column(name = "DATE_CREATED")
  private Date dateCreated;

  @LastModifiedDate
  @Column(name = "DATE_UPDATED")
  private Date dateUpdated;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getDateCreated() {
    return dateCreated;
  }

  public void setDateCreated(Date dateCreated) {
    this.dateCreated = dateCreated;
  }

  public Date getDateUpdated() {
    return dateUpdated;
  }

  public void setDateUpdated(Date dateUpdated) {
    this.dateUpdated = dateUpdated;
  }
}
