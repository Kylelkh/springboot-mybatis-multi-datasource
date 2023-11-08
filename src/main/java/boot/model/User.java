package boot.model;

import org.springframework.stereotype.Component;

@Component
public class User {


    private Integer userId;

    private String userName;


    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}
