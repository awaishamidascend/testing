package efx_aman;

import java.util.List;

public class AmanVO {

    private List<AmanVO> Users;
    private String username;
    private String password;

    // Getters and Setters
    public List<AmanVO> getUsers() {
        return Users;
    }
//Tet
    public void setUsers(List<AmanVO> users) {
        Users = users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
