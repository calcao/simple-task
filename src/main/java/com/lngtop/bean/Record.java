package com.lngtop.bean;

/**
 * 
 * @author caoxiaoming
 *
 */
public class Record {
  
  private String id;
  
  private String foo;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFoo() {
    return foo;
  }

  public void setFoo(String foo) {
    this.foo = foo;
  }

  @Override
  public String toString() {
    return "Record [id=" + id + ", foo=" + foo + "]";
  }

  
  
  
}
