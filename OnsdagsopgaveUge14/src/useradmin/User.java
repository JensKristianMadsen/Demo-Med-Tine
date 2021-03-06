package useradmin;

public class User {
  private int id;
  private String name;
  private String password;

  User(int id) {
    this.id = id;
  }

  User(int id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return "User = " + "id: " + id + ", name: " + name + ", password: " + password;
  }
}
