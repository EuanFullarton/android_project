package example.codeclan.com.wagr;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 24/04/2017.
 */

public class UserListTest {

    UserList userList;


    @Before
    public void before(){
        userList = new UserList();
        userList.addNewUser(1, "Euan");

    }

    @Test
    public void getUserListTest(){
        assertEquals(1, userList.getUserList().size());
    }

    @Test
    public void addNewUserTest(){
        userList.addNewUser(2, "Jim");
        assertEquals(2, userList.getUserList().size());
    }

}
