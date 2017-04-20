package example.codeclan.com.wagr;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class UserTest {

    User user;

    @Before
    public void before() {
        user = new User("Euan");
    }

    @Test
    public void hasName(){
        assertEquals("Euan", user.getName());
    }
}
