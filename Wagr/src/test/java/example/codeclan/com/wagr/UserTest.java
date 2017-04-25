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
        user = new User(1, "Euan");
    }

    @Test
    public void hasId(){
        assertEquals(1, user.getId());
    }

    @Test
    public void hasName(){
        assertEquals("Euan", user.getName());
    }

    @Test
    public void testSetId(){
        user.setId(2);
        assertEquals(2, user.getId());
    }

    @Test
    public void testSetName(){
        user.setName("Percy");
        assertEquals("Percy", user.getName());
    }
}
