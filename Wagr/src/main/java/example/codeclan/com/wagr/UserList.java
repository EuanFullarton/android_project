package example.codeclan.com.wagr;

import java.util.ArrayList;

/**
 * Created by user on 21/04/2017.
 */

public class UserList {

    private ArrayList<User> list;

    public UserList(){

        list = new ArrayList<User>();
        list.add(new User("Euan"));

    }

    public ArrayList<User> getUserList(){
        return new ArrayList<User>(list);
    }

    public ArrayList<User> addNewUser(String new_user_name){
        User new_user = new User(new_user_name);
        list.add(new_user);
        return new ArrayList<User>(list);
    }


}
