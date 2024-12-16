package efficonx_login;

import java.util.List;

public class efficonXLoginVO {

    private List<efficonXLoginVO> Users;
    public List<efficonXLoginVO> getUsers() {
        return Users;
    }

    private String username;
    private String password;

    // Getters and setters

    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsers(List<efficonXLoginVO> users) {
        Users = users;
    }
}