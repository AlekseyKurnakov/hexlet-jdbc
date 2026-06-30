package hexlet.code;

public class User {
    private Long id;
    private String username;
    private String phone;

    public User(String name, String phone) {
        username = name;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
