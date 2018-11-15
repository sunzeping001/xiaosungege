package com.szp.sdb.entity;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
  @Id
  private Long id;
  @Property(nameInDb = "name")
  private String name;
  @Property(nameInDb = "age")
  private String age;
  @Property(nameInDb = "sex")
  private String sex;

  @Generated(hash = 596426048)
  public User(Long id, String name, String age, String sex) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.sex = sex;
  }

  @Generated(hash = 586692638)
  public User() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAge() {
    return age;
  }

  public void setAge(String age) {
    this.age = age;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
