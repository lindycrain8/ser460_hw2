package hearthealth.model;

public class User implements Role {
    private String userID;
    private String password;
    private String role;
    private String roleName;
    private String permissions;

    public User(String userID, String password, String role) {
        this.userID = userID;
        this.password = password;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String getRoleName() {
        return roleName;
    }

    @Override
    public String getPermissions() {
        return permissions;
    }
}