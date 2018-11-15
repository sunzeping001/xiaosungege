package com.szp.sdb.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student {
  @Id
  private Long id;

  private String name;

  private String age;

  private String sex;

  @Generated(hash = 377835905)
  public Student(Long id, String name, String age, String sex) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.sex = sex;
  }

  @Generated(hash = 1556870573)
  public Student() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
}
