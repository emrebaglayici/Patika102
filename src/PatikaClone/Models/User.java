package PatikaClone.Models;

public class User {
    private Integer id;
    private String name;
    private String username;
    private String type;

    public User(Integer id, String name, String username, String type) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.type = type;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
