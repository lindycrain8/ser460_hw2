package hearthealth.model;

public class Role {
    private String roleName;
    private String permissions;

    public Role(String roleName, String permissions) {
        this.roleName = roleName;
        this.permissions = permissions;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}