import entity.User;

import java.util.ArrayList;

public class Shop {
   private ArrayList<User> users = new ArrayList<User>();

    public String addUser(User user){
        this.users.add(user);
        return user.userName + " added successfully!";
    }

}
