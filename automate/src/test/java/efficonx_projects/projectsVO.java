package efficonx_projects;

import java.util.List;

public class projectsVO {

    private List<efficonx_projects.projectsVO> Users;
    public List<efficonx_projects.projectsVO> getUsers() {
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

    public void setUsers(List<efficonx_projects.projectsVO> users) {
        Users = users;
    }
}