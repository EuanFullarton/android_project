package example.codeclan.com.wagr;

import android.content.Intent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by user on 21/04/2017.
 */

public class UserList {

    private ArrayList<User> list;

    public UserList(){
        list = new ArrayList<User>();
    }

    public ArrayList<User> getList(){
        return new ArrayList<User>(list);
    }

    public void addNewUser(String name){
        list.add(new User(name));
    }


}
