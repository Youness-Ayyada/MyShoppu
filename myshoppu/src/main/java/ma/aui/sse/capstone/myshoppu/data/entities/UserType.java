package ma.aui.sse.capstone.myshoppu.data.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import io.micrometer.core.lang.NonNull;

@Entity
public class UserType extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NonNull
    private String username;

    @NotNull
    private String userType;

    public UserType(String username, @NotNull String userType) {
        this.username = username;
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


    

}