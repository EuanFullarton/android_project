package example.codeclan.com.wagr;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 20/04/2017.
 */

public class BetTest {

    Bet bet;

    @Before
    public void before(){

        bet = new Bet("Football", "Arsenal to win league", "31st May 2017", 25);
//        will come back to this at a later point, date currently a string
    }

    @Test
    public void hasCategory(){
        assertEquals("Football", bet.getCategory());
    }

    @Test
    public void hasDetails(){
        assertEquals("Arsenal to win league", bet.getDetails());
    }

    @Test
    public void hasResolvedOn(){
        assertEquals("31st May 2017", bet.getResolvedOn());
    }

    @Test
    public void hasStake(){
        assertEquals(25, (int)bet.getStake());
    }


}
