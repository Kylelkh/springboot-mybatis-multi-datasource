package boot.config;

import boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConfig {

    //构造器注入
    private User user;


    public MyConfig(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String out(){
        return user.toString();
    }

}
