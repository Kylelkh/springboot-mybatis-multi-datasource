package boot.model;

import java.util.Map;

public class YourTable {
  private int id;
  private String name;
  private int age;
  private Map<String, String> data;

  // 构造函数、getter和setter方法省略

  // 需要添加一个空的构造函数（无参数构造函数）
  public YourTable() { }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Map<String, String> getData() {
    return data;
  }

  public void setData(Map<String, String> data) {
    this.data = data;
  }
}
